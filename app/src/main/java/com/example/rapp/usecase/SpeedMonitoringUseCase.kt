package com.example.rapp.usecase

import android.util.Log
import com.example.rapp.model.SpeedEvent
import com.example.rapp.notificatin.NotificationService
import com.example.rapp.repository.CarRepository

// SpeedMonitoringUseCase.kt
class SpeedMonitoringUseCase(
    private val carRepository: CarRepository,
    private val notificationService: NotificationService
) {
    fun processSpeedEvent(event: SpeedEvent) {
        val car = carRepository.getCarById(event.carId)
        if (car == null) {
            Log.d("SpeedMonitoringUseCase","Car with ID ${event.carId} not found.")
            return
        }

        Log.d("SpeedMonitoringUseCase","Speed check for car: ${car.model}, speed: ${event.speed} km/h")

        if (event.speed > car.maxSpeedLimit) {
            notificationService.notifyRentalCompany(car, event.speed)
        } else {
            Log.d("SpeedMonitoringUseCase","Speed within limit: ${event.speed} km/h <= ${car.maxSpeedLimit} km/h\n")
        }
    }
}
