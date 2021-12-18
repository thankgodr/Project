package com.richard.edvora.feature_homepage.domain.use_cases.filterProducts

sealed class FilterOptions(val value : String){
    class ByProducts( products : String) : FilterOptions(products)
    class ByStates(states : String) : FilterOptions(states)
    class  ByCity(city : String) : FilterOptions(city)
}
