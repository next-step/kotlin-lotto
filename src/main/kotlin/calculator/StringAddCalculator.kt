package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        val numbers =
            text?.takeIf { it.isNotBlank() }
                ?.parseToNumbers()
                ?: return 0

        check(numbers.none { it < 0 }) {
            "Number must be positive or zero"
        }

        return numbers.sum()
    }

    private fun String.parseToNumbers(): List<Int> =
        this.split(DELIMITER.toRegex())
            .filter { it.isNotBlank() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException("Not a valid number")
            }

    companion object {
        private const val DELIMITER = "[/;\n,:]"
    }
}
