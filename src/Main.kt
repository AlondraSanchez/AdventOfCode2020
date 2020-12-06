fun main(){
    val day1 = Puzzle1("input.txt")
    val day2 = Puzzle2("input2.txt")
    val day3 = Puzzle3("input3.txt")
    val day4 = Puzzle4("input4.txt")
    val day5 = Puzzle5("input5.txt")

    println("Type the day")
    val selectedDay = readLine()?.toInt()
    println("################ Answers of day $selectedDay ################")
    when(selectedDay){
        1 ->{
            day1.solve()
            day1.solvePartTwo()
        }
        2 ->{
            day2.solve()
            day2.solvePartTwo()
        }
        3 ->{
            println("Answer #1: You encountered ${day3.solve(3,1)} in your way")
            day3.solvePartTwo()
        }
        4 ->{
            day4.solve()
            day4.solvePartTwo()
        }
        5 ->{
            day5.solve()
            day5.solvePartTwo()
        }
        else -> println("We haven't reached that day!")
    }
    println("##################################################")
}