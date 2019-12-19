package com.example.controller

import com.example.bean.*
import com.example.service.ISearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search-service")
class SearchController @Autowired constructor(
        private val searchService: ISearchService
) {

    @Throws(Exception::class)
    @RequestMapping("/discover/{column}/{searchText}", method = [(RequestMethod.GET)])
    fun searchDiscover(@PathVariable column: String,
                   @PathVariable searchText: String,
                   pageable: Pageable): Iterable<Discover> =
            searchService.search(
                    "discover",
                    column,
                    searchText,
                    pageable,
                    Discover::class.java
            )

    @Throws(Exception::class)
    @RequestMapping("/user/{column}/{searchText}", method = [(RequestMethod.GET)])
    fun searchUser(@PathVariable column: String,
               @PathVariable searchText: String,
               pageable: Pageable): Iterable<User> =
            searchService.search(
                    "user",
                    column,
                    searchText,
                    pageable,
                    User::class.java
            )

    @Throws(Exception::class)
    @RequestMapping("/item/{column}/{searchText}", method = [(RequestMethod.GET)])
    fun searchItem(@PathVariable column: String,
               @PathVariable searchText: String,
               pageable: Pageable): Iterable<Item> =
            searchService.search(
                    "item",
                    column,
                    searchText,
                    pageable,
                    Item::class.java
            )
                    .also { print(it) }

    @Throws(Exception::class)
    @RequestMapping("/shop/{column}/{searchText}", method = [(RequestMethod.GET)])
    fun searchShop(@PathVariable column: String,
                   @PathVariable searchText: String,
                   pageable: Pageable): Iterable<Shop> =
            searchService.search(
                    "shop",
                    column,
                    searchText,
                    pageable,
                    Shop::class.java
            )

    @Throws(Exception::class)
    @RequestMapping("/type/{column}/{searchText}", method = [(RequestMethod.GET)])
    fun searchType(@PathVariable column: String,
                   @PathVariable searchText: String,
                   pageable: Pageable): Iterable<Type> =
            searchService.search(
                    "type",
                    column,
                    searchText,
                    pageable,
                    Type::class.java
            )

    @Throws(Exception::class)
    @RequestMapping("/menu/{column}/{searchText}", method = [(RequestMethod.GET)])
    fun searchMenu(@PathVariable column: String,
                   @PathVariable searchText: String,
                   pageable: Pageable): Iterable<Menu> =
            searchService.search(
                    "menu",
                    column,
                    searchText,
                    pageable,
                    Menu::class.java
            )
}