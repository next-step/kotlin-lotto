package calculator

data class PositiveNumbers(val value: List<Int>) {
    init {
        if (hasNegativeNumber(value)) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    fun sum(): Int {
        return value.sum()
    }

    private fun hasNegativeNumber(numbers: List<Int>): Boolean {
        return numbers.any { number -> number < 0 }
    }
}