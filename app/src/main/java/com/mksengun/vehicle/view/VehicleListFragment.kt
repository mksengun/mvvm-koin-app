package com.mksengun.vehicle.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import com.mksengun.vehicle.R
import com.mksengun.vehicle.model.Vehicle
import com.mksengun.vehicle.viewmodel.VehicleViewModel
import kotlinx.android.synthetic.main.fragment_vehicle_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class VehicleListFragment : Fragment() {

    val vehicleListModel: VehicleViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vehicle_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        vehicleListModel.getVehicles()
        vehicleListModel.listOfVehicles.observe(this, Observer(function = fun(it: List<Vehicle>?) {
            it?.let {
                lv_car.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, it)
                lv_car.onItemClickListener = OnItemClickListener { _, _, position, _ ->
                    val newFragment = VehicleDetailFragment.newInstance(it.get(position))
                    val transaction = fragmentManager!!.beginTransaction()
                    transaction.replace(R.id.frag_container, newFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }))
    }
}