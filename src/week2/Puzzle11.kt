package week2

import GeneralPuzzle

class Puzzle11(path: String) : GeneralPuzzle(path) {
    fun solve() {
        var seats = Array(list.size) { CharArray(list[0].length) }
        var occupied: Int
        var occupiedAux = 0
        var x = 0
        var a: Boolean
        var b: Boolean
        var c: Boolean
        var d: Boolean
        var e: Boolean
        var f: Boolean
        var g: Boolean
        var h: Boolean
        for (i in list.indices) {
            for (j in list[0].indices) {
                seats[i][j] = list[i][j]
            }
        }
        val aux: Array<CharArray> = copy(seats)
        do {
            occupied = occupiedAux
            //following rules
            for (i in list.indices) {
                for (j in list[0].indices) {
                    a = false
                    b = false
                    c = false
                    d = false
                    e = false
                    f = false
                    g = false
                    h = false
                    if (seats[i][j] == 'L') { //empty seat
                        if (i - 1 >= 0 && j - 1 >= 0) {
                            if (seats[i - 1][j - 1] == 'L' || seats[i - 1][j - 1] == '.') a = true
                        } else a = true
                        if (i - 1 >= 0) { // up
                            if (seats[i - 1][j] == 'L' || seats[i - 1][j] == '.') b = true
                        } else b = true
                        if (i - 1 >= 0 && j + 1 < list[0].length) { // corner B
                            if (seats[i - 1][j + 1] == 'L' || seats[i - 1][j + 1] == '.') c = true
                        } else c = true
                        if (j - 1 >= 0) { //left
                            if (seats[i][j - 1] == 'L' || seats[i][j - 1] == '.') d = true
                        } else d = true
                        if (j + 1 < list[0].length) { //right
                            if (seats[i][j + 1] == 'L' || seats[i][j + 1] == '.') e = true
                        } else e = true
                        if (i + 1 < list.size && j - 1 >= 0) { //corner c
                            if (seats[i + 1][j - 1] == 'L' || seats[i + 1][j - 1] == '.') f = true
                        } else f = true
                        if (i + 1 < list.size) { //down
                            if (seats[i + 1][j] == 'L' || seats[i + 1][j] == '.') g = true
                        } else g = true
                        if (i + 1 < list.size && j + 1 < list[0].length) { //corner d
                            if (seats[i + 1][j + 1] == 'L' || seats[i + 1][j + 1] == '.') h = true
                        } else h = true
                    }
                    if (a && b && c && d && e && f && g && h) {
                        occupiedAux++
                        aux[i][j] = '#'
                    }
                    if (seats[i][j] == '#') { //ocuped seat
                        //corner A
                        if (i - 1 >= 0 && j - 1 >= 0)
                            if (seats[i - 1][j - 1] == '#')
                                x++
                        // up
                        if (i - 1 >= 0)
                            if (seats[i - 1][j] == '#')
                                x++
                        if (i - 1 >= 0 && j + 1 < list[0].length)
                            if (seats[i - 1][j + 1] == '#')
                                x++
                        //left
                        if (j - 1 >= 0)
                            if (seats[i][j - 1] == '#')
                                x++
                        //right
                        if (j + 1 < list[0].length)
                            if (seats[i][j + 1] == '#')
                            x++
                        //corner c
                        if (i + 1 < list.size && j - 1 >= 0)
                            if (seats[i + 1][j - 1] == '#')
                                x++
                        //down
                        if (i + 1 < list.size)
                            if (seats[i + 1][j] == '#')
                                x++
                        //corner d
                        if (i + 1 < list.size && j + 1 < list[0].length)
                            if (seats[i + 1][j + 1] == '#')
                                x++

                        if (x >= 4) {
                            occupiedAux--
                            aux[i][j] = 'L'
                        }
                        x = 0
                    }
                }
            }
            seats = copy(aux)
        } while (occupied != occupiedAux)
        println("Answer #1: $occupied")
    }

    fun solvePartTwo() {
        var seats = Array(list.size) { CharArray(list[0].length) }
        var occupied: Int
        var occupiedAux = 0
        var x = 0
        var a: Boolean
        var b: Boolean
        var c: Boolean
        var d: Boolean
        var e: Boolean
        var f: Boolean
        var g: Boolean
        var h: Boolean
        for (i in list.indices) {
            for (j in list[0].indices) {
                seats[i][j] = list[i][j]
            }
        }
        val aux: Array<CharArray> = copy(seats)
        var ite: Int
        do {
            occupied = occupiedAux
            //following rules
            for (i in list.indices) {
                for (j in list[0].indices) {
                    a = true
                    b = true
                    c = true
                    d = true
                    e = true
                    f = true
                    g = true
                    h = true
                    ite = 1
                    if (seats[i][j] == 'L') {
                        while (true) {
                            if (i - ite >= 0 && j - ite >= 0) { //corner A
                                if (seats[i - ite][j - ite] == 'L') break
                                else if (seats[i - ite][j - ite] == '#') {
                                    a = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i - ite >= 0) { // up
                                if (seats[i - ite][j] == 'L') break
                                else if (seats[i - ite][j] == '#') {
                                    c = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i - ite >= 0 && j + ite < list[0].length) { // corner B
                                if (seats[i - ite][j + ite] == 'L') break
                                else if (seats[i - ite][j + ite] == '#') {
                                    c = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (j - ite >= 0) { //left
                                if (seats[i][j - ite] == 'L') break
                                else if (seats[i][j - ite] == '#') {
                                    d = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (j + ite < list[0].length) { //right
                                if (seats[i][j + ite] == 'L') break
                                else if (seats[i][j + ite] == '#') {
                                    e = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i + ite < list.size && j - ite >= 0) { //corner c
                                if (seats[i + ite][j - ite] == 'L') break
                                else if (seats[i + ite][j - ite] == '#') {
                                    f = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i + ite < list.size) { //down
                                if (seats[i + ite][j] == 'L') break
                                else if (seats[i + ite][j] == '#') {
                                    g = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i + ite < list.size && j + ite < list[0].length) { //corner d
                                if (seats[i + ite][j + ite] == 'L') break
                                else if (seats[i + ite][j + ite] == '#') {
                                    h = false
                                    break
                                }
                            } else break
                            ite++
                        }
                        if (a && b && c && d && e && f && g && h) {
                            occupiedAux++
                            aux[i][j] = '#'
                        }
                    }
                    if (seats[i][j] == '#') {
                        while (true) {
                            if (i - ite >= 0 && j - ite >= 0) { //corner A
                                if (seats[i - ite][j - ite] == 'L') break
                                else if (seats[i - ite][j - ite] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i - ite >= 0) { // up
                                if (seats[i - ite][j] == 'L') break
                                else if (seats[i - ite][j] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i - ite >= 0 && j + ite < list[0].length) { // corner B
                                if (seats[i - ite][j + ite] == 'L') break
                                else if (seats[i - ite][j + ite] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (j - ite >= 0) { //left
                                if (seats[i][j - ite] == 'L') break
                                else if (seats[i][j - ite] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (j + ite < list[0].length) { //right
                                if (seats[i][j + ite] == 'L') break
                                else if (seats[i][j + ite] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i + ite < list.size && j - ite >= 0) { //corner c
                                if (seats[i + ite][j - ite] == 'L') break
                                else if (seats[i + ite][j - ite] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i + ite < list.size) { //down
                                if (seats[i + ite][j] == 'L') break
                                else if (seats[i + ite][j] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        ite = 1
                        while (true) {
                            if (i + ite < list.size && j + ite < list[0].length) { //corner d
                                if (seats[i + ite][j + ite] == 'L') break
                                else if (seats[i + ite][j + ite] == '#') {
                                    x++
                                    break
                                }
                            } else break
                            ite++
                        }
                        if (x >= 5) {
                            occupiedAux--
                            aux[i][j] = 'L'
                        }
                        x = 0
                    }
                }
            }
            seats = copy(aux)
        } while (occupied != occupiedAux)
        println("Answer #2: $occupied")
    }

    private fun copy(original: Array<CharArray>): Array<CharArray> {
        val copy = Array(original.size) { CharArray(original[0].size) }
        for (i in original.indices)
            System.arraycopy(original[i], 0, copy[i], 0, original[0].size)
        return copy
    }
}