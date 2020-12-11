package week2

import Files

class Puzzle6 (path:String){
    private val file = Files(path)
    private val letters = file.openAnfMergeLines()
    private val groups: Array<String> = letters.split(",").toTypedArray()

    fun solve(){
        var answer =0
        for (string in groups){
            for (i in 97..122){
                if(string.indexOf(i.toChar()) >= 0){
                    answer++
                }
            }
        }
        println("Answer #1: $answer")
    }

    fun solvePartTwo(){
        var answer = 0
        var aux = false
        var z: Char
        var p: String
        var person: Array<String>
        for (string in groups){
            person = string.trim().split(" ").toTypedArray()
            if(person.size == 1)
                answer += person[0].length
            else {
                p = person[0]
                var i = 0
                while(i < p.length){
                    z = p[i]
                    for (per in person)
                        if(per.contains(z))
                            aux = true
                        else {
                            aux = false
                            break
                        }
                    if(aux)
                        answer++
                    i++
                }
            }
        }
        println("Answer #2: $answer")
    }
}