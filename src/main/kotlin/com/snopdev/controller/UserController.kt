package com.snopdev.controller

import com.snopdev.model.Address
import com.snopdev.model.User
import com.snopdev.model.request.UserRequest
import com.snopdev.service.UserService
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller(value = "/api/user", produces = [MediaType.APPLICATION_JSON])
class UserController(
    private val userService: UserService
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body userRequest: UserRequest) =
        this.userService.createUser(
            user = userRequest.toModel()
        )

    @Get
    @Status(HttpStatus.OK)
    fun getAll() =
        this.userService.getAll()

    @Get(value = "/{id}")
    fun getById(@PathVariable(value = "id") id: Long) =
        this.userService.getById(id)

    @Put(value = "/{id}")
    fun update(@PathVariable(value = "id") id: Long, @Body request: UserRequest, @Header("X-Foo") header: String): User {
        println("Header: $header")

        return this.userService.update(id, request.toModel())
    }

    @Delete(value = "/{id}")
    @Status(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable(value = "id") id: Long) {

        return this.userService.delete(id)
    }

    private fun UserRequest.toModel() : User = User(
        name = this.name,
        email = this.email,
        address = Address(
            street = this.street,
            city = this.city,
            state = this.state,
            country = this.country,
            zipcode = this.zipcode,
        )
    )
}