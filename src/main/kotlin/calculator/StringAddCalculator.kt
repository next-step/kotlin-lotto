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
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return numbers.sum()
    }
}
