package com.richard.edvora.feature_homepage.presentation.homepage

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.richard.edvora.commons.Resource
import com.richard.edvora.feature_homepage.domain.model.Product
import com.richard.edvora.feature_homepage.domain.model.ProductCategory
import com.richard.edvora.feature_homepage.domain.use_cases.filterProducts.FilterByUseCase
import com.richard.edvora.feature_homepage.domain.use_cases.filterProducts.FilterOptions
import com.richard.edvora.feature_homepage.domain.use_cases.getProducts.GetProductUseCase
import com.richard.edvora.feature_homepage.presentation.model.FIlterDataUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    private val filterByuseCase : FilterByUseCase
) : ViewModel() {
        private val _productList = mutableStateOf(ProductListState())
        val productList : State<ProductListState> = _productList
        private val category = mutableSetOf<String>()
        private val _location: MutableState<MutableList<String>> = mutableStateOf(mutableListOf(""))
        private val _categoryList : MutableState<List<ProductCategory>> = mutableStateOf(mutableListOf())
        val categoryList : State<List<ProductCategory>> = _categoryList
        private val _stateList : MutableState<MutableSet<String>> = mutableStateOf(mutableSetOf<String>())
        val stateList : State<Set<String>> = _stateList
        private val _cityList : MutableState<MutableSet<String>> = mutableStateOf(mutableSetOf<String>())
        val cityList : State<Set<String>> = _cityList
        private val _productNameList : MutableState<MutableSet<String>> = mutableStateOf(mutableSetOf<String>())
        val productNameList : State<Set<String>> = _productNameList
       private val iniTvals_ = mutableStateOf(ProductListState())

    init {
        getProducts()
    }

    //Get products from api using the use case
    private fun getProducts(){
        getProductUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.forEach {
                            category.add(it.brandName);
                             _location.value.add(it.location)
                            _stateList.value.add(it.state)
                            _cityList.value.add(it.city)
                            _productNameList.value.add(it.name)
                    }
                    _productList.value = ProductListState(products = result.data ?: emptyList())
                    _categoryList.value = categorized()
                    iniTvals_.value = ProductListState(products = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _productList.value = ProductListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _productList.value = ProductListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    //Filter initials list;
    private fun filter(filterOptions: FilterOptions) : List<Product> {
        if(!_productList.value.products.isNullOrEmpty()){
          val newList =  filterByuseCase(_productList.value.products, filterOptions)
             return newList
        }
        return emptyList();
    }

    //Filter with already Filtered List
    private fun filter(filterOptions: FilterOptions, currentList : List<Product>) : List<Product> {
        val newList =  filterByuseCase(currentList, filterOptions)
        return newList

    }

    //Categorized defaults list
     private fun categorized() : List<ProductCategory>{

         val categoryList = mutableListOf<ProductCategory>()
         category.forEach{
          val cat = ProductCategory(it, filter(FilterOptions.ByProducts(it)))
             categoryList.add(cat)
        }
         return categoryList.toList()
    }
    //Categorided optional list
    private fun categorized(list : List<Product>) : List<ProductCategory>{
        val categoryList = mutableListOf<ProductCategory>()
        category.forEach{
            val cat = ProductCategory(it, filter(FilterOptions.ByProducts(it), list))
            categoryList.add(cat)
        }
        return categoryList.toList()
    }


    //Filter Location feature
   private fun filterByCity(city : String){
        val newList = filter(FilterOptions.ByCity(city), _productList.value.products)
        _productList.value = ProductListState(products = newList)
        val categorizedResult = categorized(newList)
        _categoryList.value = categorizedResult
    }

    //Filter Location feature
    private fun filterByProduct(name : String){
        val newList = filter(FilterOptions.ByName(name), _productList.value.products)
        _productList.value = ProductListState(products = newList)
        val categorizedResult = categorized(newList)
        _categoryList.value = categorizedResult
    }

    fun doFilter(filterData : FIlterDataUi){
        if(filterData.name.equals("Product")){
            filterByProduct(filterData.value)
        }
        if(filterData.name.equals("State")){
            filterByCity(filterData.value)
        }
        if(filterData.name.equals("City")){
            filterByCity(filterData.value)
        }
    }

    fun resetFilters(){
        _productList.value = iniTvals_.value
        _categoryList.value = categorized()
    }




}