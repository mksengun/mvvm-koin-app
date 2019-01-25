package com.mksengun.vehicle.repository

import com.mksengun.vehicle.VehicleApi
import com.mksengun.vehicle.model.Vehicle
import com.mksengun.vehicle.model.VehicleListDao
import retrofit2.Call
import retrofit2.Response

class VehicleRepository(val vehicleApi: VehicleApi) {

    fun getVehicles(onVehiclesReady: OnVehiclesReady) {
        vehicleApi.getVehicles().enqueue(object : retrofit2.Callback<VehicleListDao> {
            override fun onResponse(call: Call<VehicleListDao>, response: Response<VehicleListDao>) {
                onVehiclesReady.onReady((response.body() as VehicleListDao).vehicles)
            }

            override fun onFailure(call: Call<VehicleListDao>, t: Throwable) {
                onVehiclesReady.onFail()
            }
        })
    }

    interface OnVehiclesReady {
        fun onReady(data: List<Vehicle>)
        fun onFail()
    }
}

