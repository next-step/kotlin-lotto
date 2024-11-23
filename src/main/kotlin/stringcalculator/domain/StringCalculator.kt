package stringcalculator.domain

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (input.toIntOrNull() != null) {
            return input.toInt()
        }

        if (input.startsWith("//")) {
            val regex = Regex("//(.*)\n(.*)")
            val matchResult = regex.find(input)
            val customDelimiter = matchResult?.groupValues?.get(1) ?: ""
            val numbersPart = matchResult?.groupValues?.get(2) ?: ""

            val delimitersRegex = Regex("[${Regex.escape(customDelimiter)},:]")
            val numbers = numbersPart.split(delimitersRegex).filter { it.isNotBlank() }.map { validateAndParse(it) }
            return numbers.sum()
        }

        val tokens = input.split("[,:]".toRegex()).map { validateAndParse(it) }
        return tokens.sum()
    }

    private fun validateAndParse(value: String): Int {
        val number = value.toIntOrNull() ?: throw RuntimeException("Invalid number: $value")
        if (number < 0) {
            throw RuntimeException("Negative numbers are not allowed: $value")
        }
        return number
    }
}
