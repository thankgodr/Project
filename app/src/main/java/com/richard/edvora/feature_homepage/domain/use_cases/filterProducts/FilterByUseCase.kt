package com.richard.edvora.feature_homepage.domain.use_cases.filterProducts

import com.richard.edvora.feature_homepage.domain.model.Product
import javax.inject.Inject

class FilterByUseCase @Inject constructor(){
    operator fun invoke(list: List<Product>, filterOptions: FilterOptions) : List<Product> {
        when(filterOptions){
            is FilterOptions.ByProducts -> {
                return list.filter { product ->
                    product.brandName.equals(filterOptions.value)
                }

            }
            is FilterOptions.ByCity -> {
                return list.filter { product ->
                    product.location.contains(filterOptions.value)
                }
            }
            is FilterOptions.ByStates -> {
                return list.filter { product ->
                    product.location.contains(filterOptions.value)
                }
            }
            is FilterOptions.ByName -> {
                return list.filter { product->
                    product.name == filterOptions.value
                }
            }
        }
    }
}