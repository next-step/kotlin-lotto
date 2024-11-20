package calulator

class Numbers(private val numbers: List<Int>) {
    val sum = numbers.sum()

    init {
        validateNonNegative()
    }

    private fun validateNonNegative() {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }
}
