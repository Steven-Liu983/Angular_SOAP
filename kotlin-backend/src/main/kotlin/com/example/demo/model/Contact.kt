package com.example.demo.model

import jakarta.persistence.*

@Entity
@Table(name = "contact")
data class Contact (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String
)
