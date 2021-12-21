package com.richard.edvora.feature_homepage.domain.use_cases.filterProducts

sealed class FilterOptions(val value : String, val name : String = ""){
    class ByProducts( products : String) : FilterOptions(products, "Products")
    class ByStates(states : String) : FilterOptions(states, "State")
    class  ByCity(city : String) : FilterOptions(city, "City")
    class  ByName(city : String) : FilterOptions(city, "City")
}
