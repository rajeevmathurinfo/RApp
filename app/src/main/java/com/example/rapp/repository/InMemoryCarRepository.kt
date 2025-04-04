package com.example.rapp.repository

import com.example.rapp.model.Car

// InMemoryCarRepository.kt
class InMemoryCarRepository : CarRepository {
    private val cars = mutableMapOf<String, Car>()

    override fun getCarById(carId: String): Car? = cars[carId]

    override fun updateCar(car: Car) {
        cars[car.id] = car
    }

    override fun addCar(car: Car) {
        cars[car.id] = car
    }
}
