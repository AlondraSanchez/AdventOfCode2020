package week1

import GeneralPuzzle

class Puzzle2(path: String) : GeneralPuzzle(path) {
    fun solve() {
        var password: String
        var x: Char
        var firstNumber: Byte
        var secondNumber: Byte
        var count: Byte = 0
        var masterCount: Short = 0
        var aux: CharArray
        for (string in list) {
            x = string[string.indexOf(" ") + 1]
            password = string.substring(string.indexOf(":") + 1).trim { it <= ' ' }
            firstNumber = string.substring(0, string.indexOf("-")).toInt().toByte()
            secondNumber = string.substring(string.indexOf("-") + 1, string.indexOf(" ")).toInt().toByte()
            aux = password.toCharArray()
            for (c in aux) {
                if (c == x) {
                    count++
                }
            }
            if (count in firstNumber..secondNumber) {
                masterCount++
            }
            count = 0
        }
        println("$masterCount passwords are valid")
    }

    fun solvePartTwo() {
        var password: String
        var firstPosition: Byte
        var secondPosition: Byte
        var masterCount: Short = 0
        var x: Char
        for (string in list) {
            x = string[string.indexOf(" ") + 1]
            password = string.substring(string.indexOf(":") + 1).trim { it <= ' ' }
            firstPosition = string.substring(0, string.indexOf("-")).toInt().toByte()
            secondPosition = string.substring(string.indexOf("-") + 1, string.indexOf(" ")).toInt().toByte()
            if (password[firstPosition - 1] == x && password[secondPosition - 1] != x) {
                masterCount++
            } else if (password[firstPosition - 1] != x && password[secondPosition - 1] == x) {
                masterCount++
            }
        }
        println("$masterCount passwords are valid")
    }
}