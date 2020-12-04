import java.util.regex.Matcher
import java.util.regex.Pattern

class Puzzle4(path: String) {
    private val file = Files(path)
    private val numbers = file.openAnfMergeLines()
    private val list: Array<String> = numbers.split(",").toTypedArray()

    fun solve() {
        var validPassports: Short = 0
        for (string in list) {
            if (string.contains("byr:") && string.contains("iyr:")
                && string.contains("eyr:") && string.contains("hgt:")
                && string.contains("hcl") && string.contains("ecl")
                && string.contains("pid:")
            ) {
                validPassports++
            }
        }
        println("Answer #1: $validPassports")
    }

    fun solvePartTwo() {
        var validPassports = 0
        var byr: Int
        var iyr: Int
        var eyr: Int
        var hgt: Int
        var components: Array<String>
        var flags: Byte = 0
        for (string in list) {
            if (string.contains("byr:") && string.contains("iyr:")
                && string.contains("eyr:") && string.contains("hgt:")
                && string.contains("hcl:") && string.contains("ecl:")
                && string.contains("pid:")
            ) {
                components = string.split(" ".toRegex()).toTypedArray()
                for (component in components) {
                    if (component.contains("byr")) { // birth year field
                        byr = component.substring(4).toInt()
                        if (byr in 1920..2002) {
                            flags++
                        }
                    }
                    if (component.contains("iyr")) { //issue year field
                        iyr = component.substring(4).toInt()
                        if (iyr in 2010..2020) {
                            flags++
                        }
                    }
                    if (component.contains("eyr")) { //issue year field
                        eyr = component.substring(4).toInt()
                        if (eyr in 2020..2030) {
                            flags++
                        }
                    }
                    if (component.contains("hgt")) {
                        if (component.contains("cm")) {
                            hgt = component.substring(4, component.indexOf('c')).toInt()
                            if (hgt in 150..193) {
                                flags++
                            }
                        } else if (component.contains("in")) {
                            hgt = component.substring(4, component.indexOf('i')).toInt()
                            if (hgt in 59..76) {
                                flags++
                            }
                        }
                    }
                    if (component.contains("hcl")) {
                        val pat: Pattern = Pattern.compile("#[a-f0-9]{6}")
                        val mat: Matcher = pat.matcher(component.substring(4))
                        if (mat.matches()) {
                            flags++
                        }
                    }
                    if (component.contains("ecl")) {
                        if (component.contains("amb") || component.contains("blu")
                            || component.contains("brn") || component.contains("gry")
                            || component.contains("grn") || component.contains("hzl")
                            || component.contains("oth")
                        ) {
                            flags++
                        }
                    }
                    if (component.contains("pid")) {
                        val pat: Pattern = Pattern.compile("[0-9]{9}")
                        val mat: Matcher = pat.matcher(component.substring(4))
                        if (mat.matches()) {
                            flags++
                        }
                    }
                }
                if (flags.toInt() == 7) {
                    validPassports++
                }
                flags = 0
            }
        }
        println("Answer #2: $validPassports")
    }
}