package com.example.kotlinassignment.DataModel

data class Result(
    val ResponseData: ResponseData,
    val ResponseStatus: Int,
    val Success: Boolean
)

data class ResponseData(
    val area: List<Area>,
    val country: List<Country>,
    val employee: List<Employee>,
    val region: List<Region>,
    val zone: List<Zone>
)

data class Area(
    val area: String,
    val territory: String
)

data class Country(
    val country: String,
    val territory: String
)

data class Employee(
    val area: String,
    val name: String,
    val territory: String
)

data class Region(
    val region: String,
    val territory: String
)

data class Zone(
    val territory: String,
    val zone: String
)