package week1

import GeneralPuzzle

class Puzzle3(path: String) : GeneralPuzzle(path) {

    fun solve(x: Int, y: Int): Short {
        var row: CharArray
        var position = 0
        var trees: Short = 0
        var i = y
        while (i < list.size) {
            position = (position + x) % list[i].length
            row = list[i].toCharArray()
            if (row[position] == '#') {
                trees++
            }
            i += y
        }
        return trees
    }

    fun solvePartTwo() {
        val a = solve(1, 1)
        val b = solve(3, 1)
        val c = solve(5, 1)
        val d = solve(7, 1)
        val e = solve(1, 2)
        println("Answer #2: " + a * b * c * d * e)
    }
}