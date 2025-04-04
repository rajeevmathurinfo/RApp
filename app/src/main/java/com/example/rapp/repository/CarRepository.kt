package com.example.rapp.repository

import com.example.rapp.model.Car

// CarRepository.kt
interface CarRepository {
    fun getCarById(carId: String): Car?
    fun updateCar(car: Car)
    fun addCar(car: Car)
}
