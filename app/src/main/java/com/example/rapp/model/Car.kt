package com.example.rapp.model

// Car.kt
data class Car(
    val id: String,
    val model: String,
    val renter: Renter,
    var maxSpeedLimit: Int
)
