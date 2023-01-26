package com.example.finalproject

import androidx.lifecycle.ViewModel

class loginViewModel: ViewModel() {
    var name="Yara@gmail.com"
    var password = "12345"
    fun person(input:String):Boolean{
        if(input==name){
            return true}
        else{return false}
    }
    fun pass(pas:String):Boolean{
        if(pas.length==5){
            return true}
        else{
            return false
        }
    }}