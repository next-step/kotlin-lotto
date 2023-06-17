package string.add.calculator

class Number(
    val value: Int
) {
    init {
        validatePositive(value)
    }

    private fun validatePositive(value: Int) {
        require(value > ZERO) { ErrorMessage.NEGATIVE_NUMBER_PASSED.message }
    }

    companion object {
        private const val ZERO: Int = 0
    }
}
