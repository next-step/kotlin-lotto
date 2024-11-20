package stringcalculator

class StringCalculator {
    fun calculate(inputString: String): Int {
        val numbers = inputString.split(",", ":")
        return numbers.sumOf { it.toInt() }
    }
}
