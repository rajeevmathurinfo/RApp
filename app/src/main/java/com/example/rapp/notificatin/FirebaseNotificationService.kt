package com.example.rapp.notificatin

import android.util.Log
import com.example.rapp.model.Car

// FirebaseNotificationService.kt
class FirebaseNotificationService : NotificationService {
    override fun notifyRentalCompany(car: Car, speed: Int) {
        // Simulate sending notification through Firebase
        Log.d("SpeedMonitoringUseCase","** Firebase Alert: Car [${car.model}] driven by [${car.renter.name}] exceeded speed limit! **")
        Log.d("SpeedMonitoringUseCase","Speed Recorded: $speed km/h, Limit: ${car.maxSpeedLimit} km/h\n")
    }
}
