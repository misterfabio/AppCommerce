package com.fabiocarvalho.appcommerce

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.adapters.OrderAdapter
import com.fabiocarvalho.appcommerce.viewmodel.OrderViewModel
import com.fabiocarvalho.appcommerce.viewmodel.UserViewModel


class OrderFragment : Fragment() {

    lateinit var recyclerOrder: RecyclerView

    private val orderViewModel by viewModels<OrderViewModel>()

    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_order, container, false)

        recyclerOrder = view.findViewById(R.id.rv_order)

        val adapterOrder = OrderAdapter(requireContext())

        //TODO verificar viewLifecyclerOwner abaixo:
        userViewModel.isLogged().observe(viewLifecycleOwner, Observer {
            if (it != null)
            //TODO verificar viewLifecyclerOwner abaixo:
            orderViewModel.getOrdersByUser("").observe(viewLifecycleOwner, Observer { orders ->
                adapterOrder.list = orders
                adapterOrder.notifyDataSetChanged()
            })
            else {
                activity?.finish()
                startActivity(Intent(activity, UserLoginActivity::class.java))
            }
        })

        recyclerOrder.adapter = adapterOrder
        recyclerOrder.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        return view
    }

}