package com.example.kotlinboard

data class User(
    var name: String,
    var id:String,
    var password:String,
    var uId:String
){
    constructor(): this("","","", "")
}
