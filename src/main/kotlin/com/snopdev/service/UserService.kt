package com.snopdev.service

import com.snopdev.com.snopdev.repository.AddressRepository
import com.snopdev.model.User
import com.snopdev.repository.UserRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserService(

    @Inject
    private val userRepository: UserRepository,

    @Inject
    private val addressRepository: AddressRepository
) {

    fun createUser(user: User): User {
        return this.userRepository.save(user)
    }

    fun getAll(): List<User> {
        return this.userRepository.findAll()
    }

    fun getById(id: Long): User {
        return this.userRepository.findById(id).orElseThrow { HttpStatusException(HttpStatus.NOT_FOUND, "User with ID $id was not found.") }
    }

    fun update(id: Long, user: User): User {

        val getUser = getById(id)

        val updated = user.copy(id = getUser.id)

        return this.userRepository.save(updated)
    }

    fun delete(id: Long) {

        val user = getById(id)
        this.userRepository.deleteById(id)
        this.addressRepository.deleteById(user.address.id)
    }
}