package calculator

class StringAddCalculator(
    private val input: String?
) {
    private val numbers: List<Int> = ArrayList()
    fun separateStrings(): List<Int> {
        return if (input.isNullOrBlank()) {
            listOf(0)
        } else {
            input.split(",", ":").map { it.toInt() }
        }
    }
    fun calculate(): Int {
        return numbers.sum()
    }
}
