package com.snopdev.model.request

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable.Deserializable

@Introspected
@Deserializable
data class UserRequest(
    val name: String,
    val email: String,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val zipcode: String
)
