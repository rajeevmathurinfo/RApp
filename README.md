# Speed Monitoring Alert System

A Kotlin-based logic demo for a car rental company that detects when a rented vehicle exceeds its speed limit and triggers a dummy Firebase alert.

## What It Does

- Simulates renters and cars.
- Assigns per-customer speed limits.
- Processes speed events and triggers notifications via a mock Firebase service.

## Tech Stack

- Kotlin (pure logic, no backend, no UI)
- Console or Android log simulation
- In-memory data
- Dummy Firebase alert (via `Log.d()`)

## Modules

- `model/` - Data classes for Car, Renter, and SpeedEvent
- `repository/` - In-memory data source
- `usecase/` - Business logic to process speed events
- `notification/` - Simulated Firebase alerts
- `Main.kt` - Sample usage

## Run It

1. Clone the repo.
2. Open in Android Studio (or IntelliJ IDEA).
3. Run `Main.kt` or hook into your Android Activity.
4. Check Logcat for output.

## Notes

- No Firebase SDK is used; alerts are simulated with logs.
- Fully extensible to connect real Firebase or AWS later.
