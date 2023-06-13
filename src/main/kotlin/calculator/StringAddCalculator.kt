package calculator

class StringAddCalculator {
    private val numbers: List<Int> = ArrayList()
    fun separateStrings(input: String?): List<Int> {
        return if (input.isNullOrBlank()) {
            listOf(0)
        } else {
            input.split(",", ":").map { it.toInt() }
        }
    }
    fun add(): Int {
        return numbers.sum()
    }
}
