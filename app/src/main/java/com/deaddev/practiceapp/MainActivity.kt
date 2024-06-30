package com.deaddev.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random

enum class DriveWheel {
    Front,
    Rear,
    All
};

enum class CarType {
    Sedan,
    Coupe,
    Sports,
    Wagon,
    Hatchback,
    Convertible,
    Crossover,
    Minivan,
    Pickup
}

enum class CarCondition {
    FactoryNew,
    Excellent,
    Good,
    Bad,
    Worst,
    Junk
}

enum class EVChargeType {
    Slow,
    Fast,
    Rapid
}

enum class GasolineType(val v: Int) {
    G92(92),
    G95(95),
    G98(98),
    G100(100);

    override fun toString(): String {
        return v.toString()
    }
}

enum class EngineType {
    Unknown,
    Gasoline,
    Diesel,
    Electrical,
    Hybrid
}

open class Car(
    private val model: String,
    private val type: CarType,
    private val yearOfManufacture: Int,
    private val maxSpeed: Double = 0.0,
    private val driveWheel: DriveWheel
) {

    fun race(other: Car): Boolean {
        return maxSpeed > other.maxSpeed
    }

    open fun print_info() {
        println(
            "${type.name} $model ($yearOfManufacture): \n\tDrive wheel: ${driveWheel.name}\n\tMax speed: $maxSpeed"
        )
    }
}

class GasolineCar(
    private val octaneNumber: GasolineType,
    model: String,
    type: CarType,
    yearOfManufacture: Int,
    maxSpeed: Double,
    driveWheel: DriveWheel
) : Car(
    model, type,
    yearOfManufacture, maxSpeed, driveWheel
) {
    override fun print_info() {
        super.print_info()
        println("\tGasoline type: ${octaneNumber.toString()}")
    }
}

class DieselCar(
    private val hasCustomHeater: Boolean,
    model: String,
    type: CarType,
    yearOfManufacture: Int,
    maxSpeed: Double,
    driveWheel: DriveWheel
) : Car(
    model, type,
    yearOfManufacture, maxSpeed, driveWheel
) {
    override fun print_info() {
        super.print_info()
        println("\t${if (hasCustomHeater) "Has" else "No"} custom heater")
    }
}

class ElectricalCar(
    private val chargeType: EVChargeType,
    model: String,
    type: CarType,
    yearOfManufacture: Int,
    maxSpeed: Double,
    driveWheel: DriveWheel
) : Car(
    model, type,
    yearOfManufacture, maxSpeed, driveWheel
) {
    override fun print_info() {
        super.print_info()
        println("\tCharge type: ${chargeType.name}")
    }
}

class HybridCar(
    private val octaneNumber: GasolineType,
    private val chargeType: EVChargeType,
    model: String,
    type: CarType,
    yearOfManufacture: Int,
    maxSpeed: Double,
    driveWheel: DriveWheel
) : Car(
    model, type,
    yearOfManufacture, maxSpeed, driveWheel
) {

    override fun print_info() {
        super.print_info()
        println(
            "\tCharge type: ${chargeType.name}\n\tGasoline type: ${octaneNumber.toString()}"
        )
    }
}

class CarBuilder(type: EngineType?) {
    private var engineType: EngineType = type ?: EngineType.Unknown
    private var model: String? = null
    private var type: CarType? = null
    private var yearOfManufacture: Int? = null
    private var maxSpeed: Double? = null
    private var driveWheel: DriveWheel? = null
    private var octaneNumber: GasolineType? = null
    private var hasCustomHeater: Boolean? = null
    private var chargeType: EVChargeType? = null

    fun model(_model: String) = apply { model = _model }
    fun type(_type: CarType) = apply { type = _type }
    fun yearOfManufacture(_year: Int) = apply { yearOfManufacture = _year }
    fun maxSpeed(_speed: Double) = apply { maxSpeed = _speed }
    fun driveWheel(_wheel: DriveWheel) = apply { driveWheel = _wheel }
    fun octaneNumber(_number: GasolineType) = apply { octaneNumber = _number }
    fun customHeater(_hasHeater: Boolean = true) = apply { hasCustomHeater = _hasHeater }
    fun chargeType(_type: EVChargeType) = apply { chargeType = _type }

    fun randomize() = apply {
        model(model ?: ("Jada ${listOf("Malina", "Ezhevika", "Klubnika").random()}"))
            .type(type ?: CarType.values().random())
            .yearOfManufacture(yearOfManufacture ?: Random.nextInt(1980, 2024))
            .maxSpeed(maxSpeed ?: Random.nextDouble(80.0, 200.0))
            .driveWheel(driveWheel ?: DriveWheel.values().random())
            .octaneNumber(octaneNumber ?: GasolineType.values().random())
            .customHeater(hasCustomHeater ?: Random.nextBoolean())
            .chargeType(chargeType ?: EVChargeType.values().random())
    }

    fun build() = when (engineType) {
        EngineType.Gasoline -> GasolineCar(
            octaneNumber ?: GasolineType.G92,
            model ?: "Unknown",
            type ?: CarType.Sedan,
            yearOfManufacture ?: 0,
            maxSpeed ?: 0.0,
            driveWheel ?: DriveWheel.Front
        )

        EngineType.Diesel -> DieselCar(
            hasCustomHeater ?: false,
            model ?: "Unknown",
            type ?: CarType.Sedan,
            yearOfManufacture ?: 0,
            maxSpeed ?: 0.0,
            driveWheel ?: DriveWheel.Front
        )

        EngineType.Electrical -> ElectricalCar(
            chargeType ?: EVChargeType.Slow,
            model ?: "Unknown",
            type ?: CarType.Sedan,
            yearOfManufacture ?: 0,
            maxSpeed ?: 0.0,
            driveWheel ?: DriveWheel.Front
        )

        EngineType.Hybrid -> HybridCar(
            octaneNumber ?: GasolineType.G92,
            chargeType ?: EVChargeType.Slow,
            model ?: "Unknown",
            type ?: CarType.Sedan,
            yearOfManufacture ?: 0,
            maxSpeed ?: 0.0,
            driveWheel ?: DriveWheel.Front
        )

        else -> Car(
            model ?: "Unknown",
            type ?: CarType.Sedan,
            yearOfManufacture ?: 0,
            maxSpeed ?: 0.0,
            driveWheel ?: DriveWheel.Front
        )
    }
}

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.start)
            button.setOnClickListener {
                val carsCount = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
                var carArray = Array<Pair<Car, Int>>(size = carsCount) { i ->
                    Pair(
                        CarBuilder(
                            EngineType.values().random()
                        ).randomize().build(), i + 1
                    )
                }
                for (car in carArray) {
                    println("#${car.second}:")
                    car.first.print_info()
                }

                while (carArray.size > 1) {
                    carArray.shuffle()
                    var newArray = arrayOf<Pair<Car, Int>>()
                    for (i in 0..<carArray.size step 2) {
                        if (i + 1 >= carArray.size) {
                            println("${carArray[i].second} skipped")
                            newArray = newArray.plus(carArray[i])
                            break
                        }
                        val (winner, winnerId) = if (carArray[i].first.race(carArray[i + 1].first))
                            Pair(carArray[i].second, i)
                        else Pair(carArray[i + 1].second, i + 1)
                        println(
                            "Car #${carArray[i].second} vs Car #${carArray[i + 1].second}: #$winner win"
                        )
                        newArray = newArray.plus(carArray[winnerId])
                    }
                    carArray = newArray
                }
                println("#${carArray[0].second} IS WINNER!")
            }
    }
}