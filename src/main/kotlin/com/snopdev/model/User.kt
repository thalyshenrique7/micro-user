package com.snopdev.model

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*

@Entity
@Serdeable
data class User(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val email: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: Address
) {
}