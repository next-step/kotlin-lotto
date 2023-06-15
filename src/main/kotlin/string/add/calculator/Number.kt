package string.add.calculator

class Number(
    val value: Int
) {
    init {
        require(value > 0) { ErrorMessage.NEGATIVE_NUMBER_PASSED.message }
    }
}
