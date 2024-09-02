package com.snopdev.com.snopdev.repository

import com.snopdev.model.Address
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface AddressRepository : CrudRepository<Address, Long> {
}