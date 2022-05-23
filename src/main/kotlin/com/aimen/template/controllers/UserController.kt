package com.aimen.template.controllers

import com.aimen.template.services.PostUserRequestBody
import com.aimen.template.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController (val service: UserService){
    @GetMapping("/users")
    fun getUsers(): Any = service.getUsers()

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable userId: UUID): Any = service.getUser(userId)

    @PostMapping("/users")
    fun createUser(@RequestBody user: PostUserRequestBody): Any = service.createUser(user)
}