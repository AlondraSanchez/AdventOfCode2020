fun main(){
    val day1 = Puzzle1("input.txt")
    val day2 = Puzzle2("input2.txt")
    val day3 = Puzzle3("input3.txt")
    val day4 = Puzzle4("input4.txt")
    val day5 = Puzzle5("input5.txt")
    val day6 = Puzzle6("input6.txt")
    val day7 = Puzzle7("input7.txt")
    val day8 = Puzzle8("input8.txt")
    val day9 = Puzzle9("input9.txt")
    val day10 = Puzzle10("input10.txt")

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
        6->{
            day6.solve()
            day6.solvePartTwo()
        }
        7 ->{
            day7.solve()
            day7.solvePartTwo()
        }
        8->{
            day8.solve()
            day8.solvePartTwo()
        }
        9 ->{
            day9.solve()
            day9.solvePartTwo()
        }
        10 ->{
            day10.solve()
            day10.solvePartTwo()
        }
        else -> println("We haven't reached that day!")
    }
    println("##################################################")
}