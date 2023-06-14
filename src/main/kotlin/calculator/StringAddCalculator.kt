package calculator

class StringAddCalculator {

    fun split(input: String): List<String> {
        return input.split(",|:".toRegex())
    }

    fun stringAdd(input: List<String>): Int {
        return input.sumOf { it.toInt() }
    }
}
