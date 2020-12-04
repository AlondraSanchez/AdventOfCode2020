class Puzzle1(path: String) : GeneralPuzzle(path) {
    fun solve() {
        var number: Int
        var complement: Short
        for (string in list) {
            number = string.toInt()
            complement = (2020 - number).toShort()
            if (numbers.contains(",$complement,")) {
                println("Answer #1:")
                println(
                    """In this list, the two entries that sum to 2020 are $number and $complement. 
Multiplying them together produces $number*$complement = ${number * complement}, so the correct answer is ${number * complement}."""
                )
                break
            }
        }
    }

    fun solvePartTwo() {
        var a: Int
        var b: Int
        var c: Int
        var complementA: Int
        var complementB: Int
        for (i in list.indices) {
            a = list[i].toInt()
            complementA = (2020 - a)
            for (j in i + 1 until list.size) {
                b = list[j].toInt()
                if (b < complementA) {
                    complementB = (2020 - a - b)
                    for (k in j + 1 until list.size) {
                        c = list[k].toInt()
                        if (c == complementB) {
                            println("Answer #2:")
                            println(
                                "Using the above example again, "
                                        + "the three entries that sum to 2020 are "
                                        + a + ", " + b + ", and " + c + ". "
                                        + "Multiplying them together produces the answer, "
                                        + a * b * c + "."
                            )
                        }
                    }
                }
            }
        }
    }
}