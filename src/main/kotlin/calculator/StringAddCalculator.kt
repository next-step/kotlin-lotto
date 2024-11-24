package calculator

data class StringAddCalculator(val numbers: List<Int>) {
    fun calculate() = numbers.sum()
}
