package com.example.rapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rapp.model.Car
import com.example.rapp.model.Renter
import com.example.rapp.model.SpeedEvent
import com.example.rapp.notificatin.FirebaseNotificationService
import com.example.rapp.repository.InMemoryCarRepository
import com.example.rapp.usecase.SpeedMonitoringUseCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        main()
    }

    // Main.kt
    fun main() {
        // Create dummy data
        val renter = Renter("r1", "John Doe", "john@example.com")
        val car = Car("c1", "Skoda Model 3", renter, maxSpeedLimit = 80)

        val repo = InMemoryCarRepository()
        repo.addCar(car)

        val firebaseService = FirebaseNotificationService()
        val useCase = SpeedMonitoringUseCase(repo, firebaseService)

        // Simulate speed events
        val events = listOf(
            SpeedEvent("c1", 75, System.currentTimeMillis()),
            SpeedEvent("c1", 85, System.currentTimeMillis()),
            SpeedEvent("c1", 100, System.currentTimeMillis())
        )

        events.forEach {
            useCase.processSpeedEvent(it)
        }
    }

}