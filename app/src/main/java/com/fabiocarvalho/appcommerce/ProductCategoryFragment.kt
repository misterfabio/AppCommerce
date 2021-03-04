package com.fabiocarvalho.appcommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.adapters.ProductCategoryAdapter
import com.fabiocarvalho.appcommerce.models.ProductCategory
import com.fabiocarvalho.appcommerce.repository.ProductsRepository
import com.fabiocarvalho.appcommerce.viewmodel.ProductViewModel

class ProductCategoryFragment : Fragment(){

    lateinit var recyclerCategory: RecyclerView

    private val productViewModel by viewModels<ProductViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_product_category, container)

        recyclerCategory = view.findViewById(R.id.rv_product_category)

        val adapterCategory = ProductCategoryAdapter(requireContext())
        productViewModel.allCategories.observe(viewLifecycleOwner, Observer{
            adapterCategory.list = it
            adapterCategory.notifyDataSetChanged()

        } )

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(requireContext(), 2)

        return view

    }

    interface Callback {
        fun itemSelected(category: ProductCategory)
    }

}