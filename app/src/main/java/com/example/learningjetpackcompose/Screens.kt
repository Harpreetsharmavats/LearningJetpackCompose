package com.example.learningjetpackcompose

sealed class Screens(val route : String){
    object MainScreen : Screens("main_screen")
    object DetailScreen : Screens("detail_screen")

    fun withArgs(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
