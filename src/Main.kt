import week1.*
import week2.*
import week3.*

fun main(){
    val day1 = Puzzle1("puzzle_inputs/input.txt")
    val day2 = Puzzle2("puzzle_inputs/input2.txt")
    val day3 = Puzzle3("puzzle_inputs/input3.txt")
    val day4 = Puzzle4("puzzle_inputs/input4.txt")
    val day5 = Puzzle5("puzzle_inputs/input5.txt")
    val day6 = Puzzle6("puzzle_inputs/input6.txt")
    val day7 = Puzzle7("puzzle_inputs/input7.txt")
    val day8 = Puzzle8("puzzle_inputs/input8.txt")
    val day9 = Puzzle9("puzzle_inputs/input9.txt")
    val day10 = Puzzle10("puzzle_inputs/input10.txt")
    val day11 = Puzzle11("puzzle_inputs/input11.txt")
    val day12 = Puzzle12("puzzle_inputs/input12.txt")
    val day13 = Puzzle13("puzzle_inputs/input13.txt")
    val day14 = Puzzle14("puzzle_inputs/input14.txt")

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
        11 ->{
            day11.solve()
            day11.solvePartTwo()
        }
        12 ->{
            day12.solve()
            day12.solvePartTwo()
        }
        13 ->{
            day13.solve()
            day13.solvePartTwo()
        }
        14 ->{
            day14.solve()
            println("PLease give it time (about 20-30secs), it's calculating something REALLY complex ;_;")
            day14.solvePartTwo()
        }
        else -> println("We haven't reached that day!")
    }
    println("##################################################")
}