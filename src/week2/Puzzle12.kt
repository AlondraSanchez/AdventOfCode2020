package week2

import GeneralPuzzle
import kotlin.math.abs

class Puzzle12(path: String) : GeneralPuzzle(path) {
    fun solve(){
        var movH = 0
        var movV = 0
        var orientation = 'E'
        for (direction in list){
            when(orientation){
                'E' -> {
                    if(direction[0] == 'F')
                        movH += direction.substring(1).toInt()
                    if(direction[0] == 'L'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'N'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'W'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'S'
                    }
                    if(direction[0] == 'R'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'S'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'W'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'N'
                    }
                }
                'S' -> {
                    if(direction[0] == 'F')
                        movV -= direction.substring(1).toInt()
                    if(direction[0] == 'L'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'E'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'N'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'W'
                    }
                    if(direction[0] == 'R'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'W'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'N'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'E'
                    }
                }
                'N' ->{
                    if(direction[0] == 'F')
                        movV += direction.substring(1).toInt()
                    if(direction[0] == 'L'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'W'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'S'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'E'
                    }
                    if(direction[0] == 'R'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'E'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'S'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'W'
                    }
                }
                'W' ->{
                    if(direction[0] == 'F')
                        movH -= direction.substring(1).toInt()
                    if(direction[0] == 'L'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'S'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'E'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'N'
                    }
                    if(direction[0] == 'R'){
                        if(direction.substring(1).toInt() == 90)
                            orientation = 'N'
                        if(direction.substring(1).toInt() == 180)
                            orientation = 'E'
                        if(direction.substring(1).toInt() == 270)
                            orientation = 'S'
                    }
                }
            }
            if(direction[0] == 'N')
                movV += direction.substring(1).toInt()
            if(direction[0] == 'S')
                movV -= direction.substring(1).toInt()
            if(direction[0] == 'E')
                movH += direction.substring(1).toInt()
            if(direction[0] == 'W')
                movH -= direction.substring(1).toInt()
        }
        println("Answer #1: ${abs(movH) + abs(movV)}")
    }

    fun solvePartTwo(){
        var h = 0
        var v = 0
        var x = 10
        var y = 1
        for (direction in list){
            val auxX = x
            val auxY = y
            when (direction[0]) {
                'F' -> {
                    h += (x * direction.substring(1).toInt())
                    v += (y * direction.substring(1).toInt())
                }
                'N' -> y += direction.substring(1).toInt()
                'S' -> y -= direction.substring(1).toInt()
                'E' -> x += direction.substring(1).toInt()
                'W' -> x -= direction.substring(1).toInt()
                'L' -> {
                    if(direction.substring(1).toInt() == 90){
                        x = -auxY
                        y = auxX
                    }
                    if(direction.substring(1).toInt() == 180){
                        x = -auxX
                        y = -auxY
                    }
                    if(direction.substring(1).toInt() == 270){
                        x = auxY
                        y = -auxX
                    }
                }
                'R' ->{
                    if(direction.substring(1).toInt() == 270){
                        x = -auxY
                        y = auxX
                    }
                    if(direction.substring(1).toInt() == 180){
                        x = -auxX
                        y = -auxY
                    }
                    if(direction.substring(1).toInt() == 90){
                        x = auxY
                        y = -auxX
                    }
                }
            }
        }
        println("Answer #2: ${abs(v) + abs(h)}")
    }
}