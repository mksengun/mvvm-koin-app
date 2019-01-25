package com.mksengun.vehicle.model

data class VehicleListDao(
    var count: Int,
    var vehicles: List<Vehicle>,
    var currentPage: Int,
    var nextPage: Int,
    var totalPages: Int
)