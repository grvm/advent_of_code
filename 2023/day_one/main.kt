import java.io.File

class DayOne {
    val NUM_ARR =
            hashMapOf(
                    "one" to "o1e",
                    "two" to "t2o",
                    "three" to "t3e",
                    "four" to "f4r",
                    "five" to "f5e",
                    "six" to "s6x",
                    "seven" to "s7n",
                    "eight" to "e8t",
                    "nine" to "n9e",
            )
    fun part_one(): Int {
        var sum = 0
        File("../inputs/day_one.txt").forEachLine() {
            val regex = "\\d".toRegex()
            var matches = regex.findAll(it)
            var digits = matches.map { it.groupValues[0] }.joinToString()
            var calibration_value = (digits.first().toString() + digits.last().toString()).toInt()
            sum += calibration_value
        }

        return sum
    }

    fun part_two(): Int {
        var sum = 0
        File("../inputs/day_one.txt").forEachLine() {
            var line = it
            NUM_ARR.map { (pattern, value) -> line = line.replace(pattern, value) }
            val regex = "\\d".toRegex()
            var matches = regex.findAll(line)
            var digits = matches.map { it.groupValues[0] }.joinToString()
            var calibration_value = (digits.first().toString() + digits.last().toString()).toInt()
            sum += calibration_value
        }

        return sum
    }
}

fun main() {
    val part_one = DayOne().part_one()
    val part_two = DayOne().part_two()
    println(part_one)
    print(part_two)
}
