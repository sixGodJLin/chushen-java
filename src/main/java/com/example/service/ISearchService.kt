package com.example.service

import org.springframework.data.domain.Pageable


interface ISearchService {

    @Throws(Exception::class)
    fun <T>search(table: String, column: String, searchText: String,
                  pageable: Pageable, clazz: Class<T>): Iterable<T>

}
