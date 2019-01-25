package com.mksengun.vehicle.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mksengun.vehicle.R
import com.mksengun.vehicle.model.Vehicle
import kotlinx.android.synthetic.main.fragment_vehicle.*


class VehicleDetailFragment : Fragment() {

    lateinit var vehicle: Vehicle

    companion object {
        const val KEY_VEHICLE = "KEY_VEHICLE"

        fun newInstance(vehicle: Vehicle): VehicleDetailFragment {
            val args = Bundle()
            args.putSerializable(KEY_VEHICLE, vehicle)
            val fragment = VehicleDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { vehicle = it.getSerializable(KEY_VEHICLE) as Vehicle }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_vehicle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_detail.text =
                "color = ${vehicle.color} \n " +
                "country = ${vehicle.country} \n " +
                "default = ${vehicle.default} \n " +
                "type = ${vehicle.type} \n " +
                "vehicleId = ${vehicle.vehicleId} \n " +
                "vrn = ${vehicle.vrn}"
    }
}