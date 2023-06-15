package calculator

class BasicCalculator {
    fun add(input: List<String>): Int {
        return input.sumOf { it.toInt() }
    }
}
