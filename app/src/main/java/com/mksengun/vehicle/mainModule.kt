package com.mksengun.vehicle

import com.mksengun.vehicle.repository.VehicleRepository
import com.mksengun.vehicle.viewmodel.VehicleViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    single { VehicleRepository(get()) }

    single { createWebService() }

    viewModel { VehicleViewModel(get()) }

}

fun createWebService(): VehicleApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("http://private-6d86b9-vehicles5.apiary-mock.com/")
        .build()

    return retrofit.create(VehicleApi::class.java)
}