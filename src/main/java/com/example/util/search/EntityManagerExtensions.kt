package com.example.util.search

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import javax.persistence.Query

fun Query.page(pageable: Pageable, total: Long): Page<*> =
        PageImpl(
                this
                        .setFirstResult(pageable.pageNumber * pageable.pageSize)
                        .setMaxResults(pageable.pageSize)
                        .resultList
                , pageable
                , total
        )
