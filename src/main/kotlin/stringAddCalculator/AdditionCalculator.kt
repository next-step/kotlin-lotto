package stringAddCalculator

class AdditionCalculator {
    fun add(positiveTokens: List<String>): Int {
        return positiveTokens.sumOf { it.trim().toInt() }
    }
}