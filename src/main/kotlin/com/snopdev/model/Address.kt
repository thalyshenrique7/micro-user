package com.snopdev.model

import jakarta.persistence.*
import io.micronaut.serde.annotation.Serdeable

@Entity
@Serdeable
data class Address(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var street: String,

    var city: String,

    var state: String,

    var country: String,

    var zipcode: String
) {
}