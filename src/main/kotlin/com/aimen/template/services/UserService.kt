package com.aimen.template.services

import com.aimen.template.entities.Names
import com.aimen.template.repositories.NameRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

data class GetUserResponse(val status: Int, val statusMessage: String, val user: List<Names>)

data class GetSingleUserResponse(val status: Int, val statusMessage: String, val user: Names)

data class PostUserRequestBody(val name: String)
data class PostUserResponse(val status: Int, val statusMessage: String, val user: Names)

@Service
class UserService(private val repository: NameRepository) {
    fun getUsers(): Any {
        return try {
            val users = repository.findAll()
            GetUserResponse(200, "Success", users)
        } catch (err: Error) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, object {
                val status = 500
                val statusMessage = "Failed to get users from db"
            }.toString())
        }
    }

    fun getUser(userId: UUID): Any {
        return try {
            val user = repository.findById(userId).orElse(null) ?: throw Error()
            GetSingleUserResponse(200, "Success", user)
        } catch (err: Error) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, object {
                val status = 500
                val statusMessage = "Failed to get user"
            }.toString())
        }
    }

    fun createUser(req: PostUserRequestBody): Any {
        return try {
            val userEntity = Names(null, req.name)
            val savedUser = repository.save(userEntity)
            PostUserResponse(200, "Success", savedUser)
        } catch (err: Error) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, object {
                val status = 500
                val statusMessage = "Failed to save user to db"
            }.toString())
        }
    }
}