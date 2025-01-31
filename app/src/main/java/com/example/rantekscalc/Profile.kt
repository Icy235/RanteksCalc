package com.example.rantekscalc

data class Profile(
    var name: String,
    var workload: String,
    var client: String,
    var totalPrice: String,
    var rent: String = "0",
    var markup: String = "0",
    var pricePerKm: String = "0",
    var distance: String = "0",
    var materialMass: String = "0",
    var materialPrice: String = "0",
    var workTime: String = "0",
    var workPrice: String = "0",
    var otherPrice: String = "0"
)