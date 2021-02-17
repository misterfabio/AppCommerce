package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.adapters.OrderAdapter
import com.fabiocarvalho.appcommerce.models.*
import java.util.*

class OrderFragment : Fragment() {

    lateinit var recyclerOrder: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_order, container, false)

        recyclerOrder = view.findViewById(R.id.rv_order)

        val product1: Product = Product(
            "1",
            "Camisa 89",
            ProductCategory("id", "Camisas"),
            "Camisa social 1",
            120.2,
            arrayListOf(ProductColor("1","Branca","#ffffff"), ProductColor("2","Preta","#000000")),
            arrayListOf(ProductSize("1", "P"), ProductSize("1", "M"), ProductSize("1", "G")),
            emptyList())
        val product2: Product = Product(
            "2",
            "Calça Jeans",
            ProductCategory("id", "Calças"),
            "Calça social 1",
            50.99,
            arrayListOf(ProductColor("1","Branca","#ffffff"), ProductColor("2","Preta","#000000")),
            arrayListOf(ProductSize("1", "P"), ProductSize("1", "M"), ProductSize("1", "G")),
            emptyList())
            val arrayOrder = arrayListOf(
                Order(UUID.randomUUID().toString(),
                Date().time,
                Order.Status.PAID,
                Order.Method.CREDIT_CARD,
                User("","","","","","", emptyList()),
                arrayListOf(OrderedProduct("1",product2,2), OrderedProduct("2",product1,3))),
                Order(UUID.randomUUID().toString(),
                Date().time,
                Order.Status.PENDENT,
                Order.Method.BOLETO,
                User("","","","","","", emptyList()),
                arrayListOf(OrderedProduct("1",product1,2), OrderedProduct("2",product2,1)))
            )

        val adapterOrder = OrderAdapter(arrayOrder,requireContext())

        recyclerOrder.adapter = adapterOrder
        recyclerOrder.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        return view
    }

}