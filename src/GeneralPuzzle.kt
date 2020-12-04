open class GeneralPuzzle(path: String){
    private val file = Files(path)
    val numbers: String = file.open()
    val list: Array<String> = numbers.split(",").toTypedArray()
}