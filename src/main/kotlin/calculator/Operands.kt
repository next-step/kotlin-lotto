package calculator

class Operands(
    private val numbers: List<Int>,
) {
    fun sum(): Int = numbers.sum()

    fun validateNonNegative() {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 계산할 수 없습니다.")
        }
    }
}
