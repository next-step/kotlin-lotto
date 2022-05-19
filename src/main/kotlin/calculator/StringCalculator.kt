package calculator

class StringCalculator {

    fun sum(numberStrings: List<String>): Int {
        return numberStrings
            .map { parseToInt(it) }
            .onEach { validateNegative(it) }
            .sumOf { it }
    }

    private fun validateNegative(number: Int) {
        if (number < ZERO) {
            throw RuntimeException()
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
