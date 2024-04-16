package com.example.graphql

import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(private val graphQLService: GraphQLService) {

    @GetMapping("/user")
    fun getUser(@RequestParam username: String) = runBlocking {
        graphQLService.getUser(username)
    }
}
