package com.example.service.impl

import com.example.service.ISearchService
import com.example.util.search.ConfigHelper
import com.example.util.search.ConfigLoader
import com.example.util.search.page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
@Transactional
open class SearchServiceImpl : ISearchService {

    private var entityManager: EntityManager? = null;
    private val configHelper = ConfigHelper(ConfigLoader.loadConfig())

    @PersistenceContext
    fun setEntityManager(entityManager: EntityManager) {
        this.entityManager = entityManager
    }

    @Throws(Exception::class)
    override fun <T> search(table: String,
                            column: String,
                            searchText: String,
                            pageable: Pageable,
                            clazz: Class<T>): Iterable<T> {
        // 检查参数的合法性
        if (!configHelper.haveTable(table)
                || !configHelper.haveColumn(table, column)) {
            throw RuntimeException("参数不合法")
        }

        fun areSearchArray(): Boolean = searchText.startsWith("[")

        val entityManager: EntityManager = this.entityManager!!

        val entityName = clazz.simpleName
        val type: String = configHelper.findType(table, column)
                ?: throw RuntimeException("[CONFIG ERROR] type can not be null")

        var hqlSelect: String = // 查询语句
                "SELECT entity FROM $entityName entity WHERE entity.$column "

        var hqlCount: String = // 统计结果长度
                "SELECT COUNT(*) FROM $entityName entity WHERE entity.$column "

        when (type) {
            "string" -> "like :searchData"
            "int", "boolean", "double" ->
                if (areSearchArray()) "IN :searchData"
                else "= :searchData"
            else ->
                if (configHelper.haveClass(type)) "= :searchData"
                else throw RuntimeException("[CONFIG ERROR] un-support column type")
        }
                .also { hqlCount += it }
                .also { hqlSelect += it }

        val searchData: Any = // 需填充的数据
                if (areSearchArray()) {
                    val searchTextArray = searchText.substring(1, searchText.length - 1).split(",")
                    when (type) {
                        "string" -> throw RuntimeException("[REQUEST BAD] un-support search data")
                        "int" -> searchTextArray.map { it.trim().toInt() }
                        "double" -> searchTextArray.map { it.trim().toDouble() }
                        "boolean" -> searchTextArray.map { it.trim().toBoolean() }
                        else -> searchTextArray.map { configHelper.newBean(type, it.trim().toInt()) }
                    }
                } else
                    when (type) {
                        "string" -> "%$searchText%"
                        "int" -> searchText.toInt()
                        "double" -> searchText.toDouble()
                        "boolean" -> searchText == "true"
                        else -> configHelper.newBean(type, searchText.toInt())
                    }

        // 此时，hql生成完毕
        // 由于search方法未优化，search方法耗时较长，且search方法只用于管理员
        // 对search方法延时处理
        // 前两页延时1秒，后面的延时2秒
        Thread.sleep(if (pageable.pageNumber < 2) 1000 else 2000)

        val totalSize: Long = // 查询数据长度
                entityManager
                        .createQuery(hqlCount)
                        .setParameter("searchData", searchData)
                        .resultList[0] as Long

        val result: Iterable<*> = // 查询结果
                entityManager
                        .createQuery(hqlSelect)
                        .setParameter("searchData", searchData)
                        .page(pageable, totalSize)

        @Suppress("UNCHECKED_CAST")
        return result as Iterable<T>
    }

}