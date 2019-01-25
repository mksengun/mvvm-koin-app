package com.mksengun.vehicle.model

import java.io.Serializable

data class Vehicle(
    var vehicleId: Int,
    var vrn: String,
    var country: String,
    var color: String,
    var type: String,
    var default: Boolean
): Serializable