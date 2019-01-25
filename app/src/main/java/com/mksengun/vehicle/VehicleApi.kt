package com.mksengun.vehicle

import com.mksengun.vehicle.model.VehicleListDao
import retrofit2.Call
import retrofit2.http.GET

interface VehicleApi{

    @GET("vehicles")
    fun getVehicles(): Call<VehicleListDao>

}