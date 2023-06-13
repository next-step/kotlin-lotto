package calculator

class StringAddCalculator(
    private val input: String?
) {
    private val numbers: List<Int> = ArrayList()
    fun separateStrings(): List<Int> {
        return input?.split(",", ":")?.map { it.toInt() } ?: listOf(0)
    }
    fun calculate(): Int {
        return numbers.sum()
    }
}
