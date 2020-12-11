package week2

import GeneralPuzzle
import kotlin.collections.ArrayList

class Puzzle10(path: String) : GeneralPuzzle(path) {
    private val arr: ArrayList<Int> = ArrayList() // our adapters
    fun solve(){
        convertArray()
        arr.sort()
        var i = 0
        var differenceOf1 = 1
        var differenceOf3 = 1

        while(i < (arr.size-1)){
            when {
                (arr[i+1]-arr[i]) == 1 -> { //difference of 1
                    differenceOf1++
                }
                (arr[i+1] - arr[i]) == 3 -> {
                    differenceOf3 ++
                }
            }
            i++
        }
        println("Answer #1: ${differenceOf1*differenceOf3}")
    }

    fun solvePartTwo(){
        var group = 0
        val dif = getDifferences()
        var res:Long = 1
        for (x in dif){
            if(x == 1 ){
                group++
            }
            if(x == 3 && group > 0){
                when(group){
                    2->{
                        res *= 2
                    }
                    3 ->{
                        res *= 4
                    }
                    4 ->{
                        res *= 7
                    }
                }
                group = 0
            }
        }
        when(group){ // last group
            2->{
                res *= 2
            }
            3 ->{
                res *= 4
            }
            4 ->{
                res *= 7
            }
        }

        println("Answer #2: $res")
    }

    private fun getDifferences(): ArrayList<Int>{
        val dif: ArrayList<Int> = ArrayList()
        var i = 0
        while(i < arr.size-1){
            dif.add(arr[i+1] - arr[i])
            i++
        }
        return dif
    }

    private fun convertArray(){
        arr.add(0)
        for(x in list){
            arr.add(x.toInt())
        }
    }
}