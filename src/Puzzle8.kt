class Puzzle8(path: String) : GeneralPuzzle(path) {
    private var finalValue = 0
    fun solve(){
        var ins: String
        var value: Int
        var pc = 0
        var stop = false
        var total = 0
        val instructions: ArrayList<Int> = ArrayList()
        while(!stop){
            ins = list[pc].substring(0, list[pc].indexOf(" "))
            value = list[pc].substring(list[pc].indexOf(" ")+1).toInt()

            if(instructions.contains(pc)) {
                stop = true
            } else {
                instructions.add(pc)
                when (ins) {
                    "nop" -> {
                        pc++
                    }
                    "acc" -> {
                        total += value
                        pc ++
                    }
                    "jmp" -> {
                        pc = ((pc + value) % list.size)
                    }
                }
            }
        }
        println("Answer #1: $total")
    }

    fun solvePartTwo(){
        var ins: String
        var value: Int
        var instructions: ArrayList<String>
        var i = 0
        while( i < list.size){
            finalValue = 0
            instructions = convertArray()
            ins = list[i].substring(0, list[i].indexOf(" "))
            value = list[i].substring(list[i].indexOf(" ")+1).toInt()

            if(ins == "nop"){
                instructions[i] = "jmp $value"
                if(valid(instructions)){
                    println("Answer #2: $finalValue")
                    break
                }
            } else if (ins == "jmp"){
                instructions[i] = "nop $value"
                if(valid(instructions)){
                    println("Answer #2: $finalValue")
                    break
                }
            }
            i++
        }

    }

    private fun valid(newInstructions: ArrayList<String>):Boolean{
        var ins: String
        var value: Int
        var pc = 0
        var total = 0
        val instructions: ArrayList<Int> = ArrayList()
        while(true){
            when {
                instructions.contains(pc) -> { //repeated instruction!
                    return false
                }
                pc >= list.size -> { //We reached the last instruction
                    finalValue = total
                    return true
                }
                else -> {
                    instructions.add(pc)
                    ins = newInstructions[pc].substring(0, newInstructions[pc].indexOf(" "))
                    value = newInstructions[pc].substring(newInstructions[pc].indexOf(" ")+1).toInt()
                    when (ins) {
                        "nop" -> {
                            pc++
                        }
                        "acc" -> {
                            total += value
                            pc ++
                        }
                        "jmp" -> {
                            pc += value
                        }
                    }
                }
            }
        }
    }
    private fun convertArray(): ArrayList<String>{
        val arr: ArrayList<String> = ArrayList()
        for(instruction in list){
            arr.add(instruction)
        }
        return arr
    }
}