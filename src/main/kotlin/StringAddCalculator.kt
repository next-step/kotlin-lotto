class StringAddCalculator(private val input: String?) {
    fun calculate(): Int {
        if (input.isNullOrEmpty()) return NUMBER_ZERO
        if (input.isNullOrBlank()) return NUMBER_ZERO
        if (input.length == INPUT_LENGTH_ONE && isNumeric(input)) return input.toInt()
        return NUMBER_ZERO
    }

    private fun isNumeric(str: String): Boolean = str
        .all { it in '0'..'9' }

    companion object {
        private const val NUMBER_ZERO = 0
        private const val INPUT_LENGTH_ONE = 1
    }
}
