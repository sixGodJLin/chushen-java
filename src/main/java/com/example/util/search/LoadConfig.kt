package com.example.util.search

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import java.lang.reflect.Method

data class Config(
        var version: String? = null,
        var search: List<Search>? = null
)

data class Search(
        var table: String? = null,
        var columns: List<Column>? = null
)

data class Column(
        var name: String? = null,
        var type: String = "string"
)

object ConfigLoader {
    fun loadConfig(): Config =
            loadConfig(File("src/main/resources/searchConfig.json"))

    fun loadConfig(file: File): Config =
            ObjectMapper().readValue(file, Config::class.java)
}

class ConfigHelper constructor(val config: Config) {

    private fun findSearch(tableName: String): Search? =
            config.search?.find { it.table == tableName }

    private fun findColumn(tableName: String, columnName: String): Column? =
            findSearch(tableName)?.columns?.find { it.name == columnName }

    fun haveTable(tableName: String) : Boolean =
            findSearch(tableName) != null

    fun findType(tableName: String, columnName: String): String? =
            findColumn(tableName, columnName)?.type

    fun haveColumn(tableName: String, columnName: String): Boolean =
            findColumn(tableName, columnName) != null

    fun haveClass (className: String): Boolean {
        return try {
            Class.forName(className)
            true
        } catch (e: ClassNotFoundException) {
            false
        }
    }

    fun newBean (beanName: String, id: Int): Any {
        val type = Class.forName(beanName)
        val method = type.getDeclaredMethod("setId", Int::class.java)
        val bean = type.newInstance()
        method.invoke(bean, id)
        return bean
    }

}