package week3
import GeneralPuzzle
import java.math.BigInteger

class Puzzle14(path: String) : GeneralPuzzle(path) {
    fun solve(){
        var sum = BigInteger("0")
        var mask = ""
        var value: String
        var aux:String
        var v: BigInteger
        val arr: ArrayList<Memory> = ArrayList()
        var index: Int
        for(x in list){
            aux = ""
            if(x.contains("mask")){
                mask = x.substring(x.indexOf("=") + 1).trim()
            } else{
                index = x.substring(4, x.indexOf(" ")-1).toInt()
                v = BigInteger(x.substring(x.indexOf("=") + 1).trim())
                value = fill(v.toString(2), mask.length)
                for (i in mask.length-1 downTo 0) {
                    aux = if (mask[i] == '1' && value[i] == '1') {
                        "1$aux"
                    } else if (mask[i] == '1' && value[i] == '0') {
                        "1$aux"
                    } else if (mask[i] == 'X' && value[i] == '1') {
                        "1$aux"
                    } else {
                        "0$aux"
                    }
                }
                var flag = false
                for (y in arr){
                    if(y.index == index) {
                        y.value = aux
                        flag = true
                        break
                    }
                }
                if(!flag){
                    arr.add(Memory(index, aux))
                }
            }
        }
        for (x in arr){
            sum = sum.add(BigInteger(x.value, 2))
        }
        println("Answer #1: $sum")
    }

    fun solvePartTwo(){
        var mask= ""
        var index: String
        val arr: ArrayList<BigMemory> = ArrayList()
        var auxPow: ArrayList<String>
        var value: String
        var sum = BigInteger("0")

        for (x in list){
            if(x.contains("mask")){
                mask = x.substring(x.indexOf("=") + 1).trim()
            } else {
                index = fill(BigInteger(x.substring(4, x.indexOf(" ")-1)).toString(2), mask.length)
                value = x.substring(x.indexOf("=") + 1).trim()
                auxPow = ArrayList()
                for (i in index.indices){
                     if (mask[i] == '0') {
                         if(auxPow.size == 0){
                             auxPow.add("${index[i]}")
                         } else {
                             for(j in auxPow.indices){
                                 auxPow[j] += "${index[i]}"
                             }
                         }
                    } else if (mask[i] == '1') {
                         if(auxPow.size == 0){
                             auxPow.add("1")
                         } else {
                             for(j in auxPow.indices){
                                 auxPow[j] += "1"
                             }
                         }
                    } else {
                         if(auxPow.size == 0){
                             auxPow.add("0")
                             auxPow.add("1")
                         } else {
                             for (m in auxPow.indices){
                                 auxPow[m] += "0"
                             }
                             val q = auxPow.size-1
                             for (m in 0..q){
                                 auxPow.add(auxPow[m].substring(0, auxPow[m].length-1) + "1")
                             }
                         }
                    }
                }
                for (add in auxPow){
                    arr.add(BigMemory(add, value))
                }
            }
        }
        val passedMem: ArrayList<String> = ArrayList()
        while(arr.size>0){
            val aux: BigMemory = arr.last()
            if(passedMem.contains(aux.index)){
                arr.removeLast()
            } else {
                passedMem.add(aux.index)
                sum = sum.add(BigInteger(aux.value))
                arr.removeLast()
            }
        }
        println("Answer #2: $sum")
    }

    private fun fill(value: String, size: Int): String{
        var aux = value
        for (i in value.length until size){
            aux = "0$aux"
        }
        return aux
    }

    data class Memory(val index: Int, var value: String)
    data class BigMemory(val index: String, var value:String)
}