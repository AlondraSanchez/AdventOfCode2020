class Puzzle9(path: String) : GeneralPuzzle(path) {
    private var array: ArrayList<Int> = ArrayList() // has 25 numbers
    private val preamble = 25
    private var badNumber = 0
    private var index = 0
    fun solve(){
        getNumbers()
        var i = preamble
        var number: Int
        while (i< list.size){
            number = list[i].toInt()
            if(validate(number)){ //the number follows the rule
                array.removeAt(0)
                array.add(number)
            } else {
                index = i
                badNumber = number
                println("Answer #1: $number")
                break
            }
            i++
        }
    }

    fun solvePartTwo(){
        var sum = 0
        var smallest: Int
        var largest = 0
        var i = 0
        var iterator = 1
        var range : ArrayList<Int> = ArrayList()
        while(sum != badNumber){
            sum+= list[i].toInt()
            range.add(list[i].toInt())
            if(sum > badNumber) {
                range = ArrayList()
                sum = 0
                i = iterator
                iterator++
            }
            i++
        }
        smallest = range[0]
        for (x in range){
            if (x < smallest)
                smallest = x
            if(x > largest)
                largest = x
        }
        println("Answer #2: ${smallest + largest}")
    }

    private fun validate(number:Int): Boolean{
        var complement: Int
        for (num in array){
            complement = (number - num)
            if(array.contains(complement) && complement != num){
                return true
            }
        }
        return false
    }

    private fun getNumbers(){
        var i = 0
        while(i<preamble){
            array.add(list[i].toInt())
            i++
        }
    }
}