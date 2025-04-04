package com.example.rapp.notificatin

import com.example.rapp.model.Car

// NotificationService.kt
interface NotificationService {
    fun notifyRentalCompany(car: Car, speed: Int)
}
