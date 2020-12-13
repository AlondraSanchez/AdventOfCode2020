package week3

import Files

class Puzzle13 (path: String){
    private val file = Files(path)
    private val numbers = file.openBuses()
    private val list: Array<String> = numbers.split("\n").toTypedArray()

    fun solve(){
        var timeAux = list[0].toInt()
        val time = list[0].toInt()
        var stop = false
        val idBuses: Array<String> = list[1].replace("x,", "").split(",").toTypedArray()
        while(!stop){
            for (id in idBuses){
                if(timeAux%id.toInt() == 0){
                    println("Answer #1: ${(timeAux-time)*id.toInt()}")
                    stop = true
                    break
                }
            }
            timeAux++
        }
    }

    fun solvePartTwo(){
        val idBuses: Array<String> = list[1].split(",").toTypedArray()
        var x = idBuses[0].toLong()
        var t = 0L
        for (i in 1 until idBuses.size){
            if(idBuses[i] != "x"){
                while ((t + i) % idBuses[i].toLong() != 0L) {
                    t += x
                }
                x *= idBuses[i].toLong()
            }
        }
        println("Answer #2: $t")
    }
}