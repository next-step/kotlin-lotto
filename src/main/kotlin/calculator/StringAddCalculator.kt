package calculator

class StringAddCalculator {
    private var numbers: List<Int> = ArrayList()
    fun separateStrings(input: String?): List<Int> {
        val separatedNumbers = if (input.isNullOrBlank()) {
            listOf(0)
        } else {
            input.split(",", ":").map { it.toInt() }
        }
        numbers = separatedNumbers
        return separatedNumbers
    }
    fun add(): Int {
        return numbers.sum()
    }
}
