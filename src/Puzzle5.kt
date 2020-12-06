class Puzzle5(path: String) : GeneralPuzzle(path) {
    fun solve(){
        var row: Int
        var column: Int
        var higher = 0
        var aux: String
        for (string in list){
            aux = string
            aux = aux.toLowerCase()
            aux = aux.replace("f", "0")
            aux = aux.replace("b", "1")
            aux = aux.replace("r", "1")
            aux = aux.replace("l", "0")
            row = Integer.parseInt(aux.substring(0,7),2)
            column = Integer.parseInt(aux.substring(7),2)

            if(((row*8) + column) > higher){
                higher = ((row*8)+column)
            }
        }
        println("Answer #1: $higher")
    }

    fun solvePartTwo(){
        val ids: ArrayList<Int> = ArrayList()
        var row: Int
        var column: Int
        var aux: String
        for (string in list){
            aux = string
            aux = aux.toLowerCase()
            aux = aux.replace("f", "0")
            aux = aux.replace("b", "1")
            aux = aux.replace("r", "1")
            aux = aux.replace("l", "0")
            row = Integer.parseInt(aux.substring(0,7),2)
            column = Integer.parseInt(aux.substring(7),2)

            ids.add(((row*8)+column))
        }

        for (id in ids){
            if(ids.contains(id+2) && !ids.contains(id+1)){
                println("Answer #2: ${id+1}")
                break
            }
        }
    }
}