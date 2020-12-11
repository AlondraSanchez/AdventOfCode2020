package week2
import Files
import java.util.ArrayList


class Puzzle7 (path: String) {
    private val file: Files = Files(path)
    private val numbers: String = file.openRules()
    private val list: Array<String> = numbers.split(".").toTypedArray()
    private lateinit var rules: ArrayList<String>

    fun solve() {
        rules = ArrayList<String>()
        convertArray()
        var stop = false
        var rule: String
        var colorBag: String
        var nextBags: String
        var bagInside: String
        val bagColors: ArrayList<String> = ArrayList<String>()
        var count = 0
        bagColors.add("shiny gold")
        while (!stop) {
            val count2 = count
            var i = 0
            while (i < rules.size) {
                rule = rules[i]
                colorBag = rule.substring(0, rule.indexOf(":"))
                nextBags = rule.substring(rule.indexOf(":") + 1)
                var j = 0
                while (j < bagColors.size) {
                    bagInside = bagColors[j]
                    if (nextBags.contains(bagInside)) {
                        count++
                        if (!bagColors.contains(colorBag)) {
                            bagColors.add(colorBag)
                        }
                        if (rules.size > 0) {
                            rules.removeAt(i)
                            j = bagColors.size
                            i--
                        }
                    }
                    j++
                }
                i++
            }
            if (count2 == count) {
                stop = true
            }
        }
        println("Answer #1: $count")
    }

    fun solvePartTwo(){
        rules = ArrayList<String>()
        convertArray()
        println("Answer #2: ${empty("shiny gold")}")
    }

    private fun empty(bag:String):Int{
        var bagColor: String
        var bagContent = ""
        var quantity: Int
        var res = 0
        for (rule in rules) {
            bagColor = rule.substring(0, rule.indexOf(":"))
            bagContent = rule.substring(rule.indexOf(":") + 1)
            if (bagColor == bag) {
                break
            }
        }

        if(bagContent.contains("no other")){
            return 0
        }
        var aux: String
        if(bagContent.contains(",")){ // +1 bolsa
            for (x in bagContent.split(",")){
                aux = x.trim()
                quantity = (aux.substring(0, aux.indexOf(" ")) + "").toInt()
                bagColor = aux.substring(aux.indexOf(" ") + 1).trim()

                res += quantity + (quantity*empty(bagColor))
            }
        } else {
            aux = bagContent.trim()
            quantity = (aux.substring(0, aux.indexOf(" ")) + "").toInt()
            bagColor = aux.substring(aux.indexOf(" ") + 1).trim()

            res += quantity + (quantity*empty(bagColor))
        }
        return res
    }

    private fun convertArray() {
        var aux: String
        for (string in list) {
            aux = string.replace(" contain ".toRegex(), ":")
            aux = aux.replace(" bags".toRegex(), "")
            aux = aux.replace(" bag".toRegex(), "")
            rules.add(aux)
        }
    }


}