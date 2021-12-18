package com.richard.edvora.feature_homepage.domain.use_cases.getProducts

import com.richard.edvora.commons.Resource
import com.richard.edvora.feature_homepage.domain.model.Product
import com.richard.edvora.feature_homepage.domain.repisitory.ProductRepisotory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repisotory: ProductRepisotory
) {
    operator fun invoke() : Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading<List<Product>>())
            val products = repisotory.getProducts()
            emit(Resource.Success<List<Product>>(products))
        }catch (e : HttpException){
            emit(Resource.Error<List<Product>>(e.localizedMessage ?: "Unknown Error" ))

        }catch (e : IOException){
            emit(Resource.Error<List<Product>>("Couldn't reach server. Check your internet connection."))
        }
    }
}