package stringcalculator.domain

class NumberParser {
    fun parse(
        numbersPart: String,
        delimitersRegex: Regex,
    ): List<Int> {
        return numbersPart.split(delimitersRegex)
            .filter { it.isNotBlank() }.map { validateAndParse(it) }
    }

    private fun validateAndParse(value: String): Int {
        val number =
            value.toIntOrNull()
                ?: throw RuntimeException("Invalid number: $value")
        if (number < 0) {
            throw RuntimeException("Negative numbers are not allowed: $value")
        }
        return number
    }
}
