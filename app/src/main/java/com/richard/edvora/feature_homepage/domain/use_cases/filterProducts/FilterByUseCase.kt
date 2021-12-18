package com.richard.edvora.feature_homepage.domain.use_cases.filterProducts

import com.richard.edvora.commons.Resource
import com.richard.edvora.feature_homepage.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class FilterByUseCase(){
    operator fun invoke(list: List<Product>, filterOptions: FilterOptions) : List<Product> {
        when(filterOptions){
            is FilterOptions.ByProducts -> {
                return list.filter { product ->
                    product.name == filterOptions.value
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
        }
    }
}