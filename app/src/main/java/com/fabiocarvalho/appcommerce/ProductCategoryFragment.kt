package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.adapters.ProductCategoryAdapter
import com.fabiocarvalho.appcommerce.models.ProductCategory

class ProductCategoryFragment : Fragment(){

    lateinit var recyclerCategory: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_product_category, container)

        recyclerCategory = view.findViewById(R.id.rv_product_category)
        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory("1","Camisas", MainActivity().fillRvProduct()),
            ProductCategory("2", "Calças", MainActivity().fillRvProduct()) ,
            ProductCategory("2", "Meias", MainActivity().fillRvProduct()),
            ProductCategory("2", "Calçados", MainActivity().fillRvProduct())
        )
        val adapterCategory = ProductCategoryAdapter(arrayCategory,requireContext())
        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(requireContext(),2)

        return view
    }

    interface Callback {
        fun itemSelected(category: ProductCategory)
    }

}