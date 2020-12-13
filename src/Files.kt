import java.io.File
import java.util.*


class Files (private val path: String){
    fun open(): String{
        var text = ""
        try {
            val input = Scanner(File(path))
            while (input.hasNextLine()) {
                val line: String = input.nextLine()
                text += "$line,"
            }
            input.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return text.substring(0, text.length-1)
    }

    fun openAnfMergeLines(): String{
        var text = ""
        try {
            val input = Scanner(File(path))
            while (input.hasNextLine()) {
                val line: String = input.nextLine()
                text += if(line == "") "$line," else {
                    "$line "
                }
            }
            input.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return text.substring(0, text.length-1)
    }

    fun openRules(): String {
        var text = ""
        try {
            val input = Scanner(File(path))
            while (input.hasNextLine()) {
                val line: String = input.nextLine()
                text += line
            }
            input.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return text.substring(0, text.length-1)
    }

    fun openBuses(): String{
        var text = ""
        try {
            val input = Scanner(File(path))
            while (input.hasNextLine()) {
                val line: String = input.nextLine()
                text += line + "\n"
            }
            input.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return text.substring(0, text.length-1)
    }
}