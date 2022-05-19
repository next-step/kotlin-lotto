package stringAddCalculator

object Calculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return input.toInt()
    }

    fun splitString(input: String): List<String> {
        return input.split(",")
    }
}
