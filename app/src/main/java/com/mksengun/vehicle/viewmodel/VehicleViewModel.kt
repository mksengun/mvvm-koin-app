package com.mksengun.vehicle.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mksengun.vehicle.model.Vehicle
import com.mksengun.vehicle.repository.VehicleRepository
import org.koin.standalone.KoinComponent


class VehicleViewModel(val vehicleRepository: VehicleRepository) : ViewModel(), KoinComponent {

    var listOfVehicles = MutableLiveData<List<Vehicle>>()

    init {
        listOfVehicles.value = listOf()
    }

    fun getVehicles() {
        vehicleRepository.getVehicles(object : VehicleRepository.OnVehiclesReady {
            override fun onReady(data: List<Vehicle>) {
                listOfVehicles.value = data
            }

            override fun onFail() {
                //REQUEST FAILED
            }
        })
    }
}