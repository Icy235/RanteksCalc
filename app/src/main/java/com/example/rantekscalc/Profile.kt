package com.example.rantekscalc

data class Profile(
    var name: String,
    var workload: String,
    var client: String,
    var totalPrice: String,
    var rent: String = "",
    var markup: String = "",
    var pricePerKm: String = "",
    var distance: String = "",
    var materialMass: String = "",
    var materialPrice: String = "",
    var workTime: String = "",
    var workPrice: String = "",
    var otherPrice: String = ""
)