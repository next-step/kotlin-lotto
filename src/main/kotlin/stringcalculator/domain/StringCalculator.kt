package stringcalculator.domain

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        return if (isCustomDelimiter(input)) {
            handleCustomDelimiter(input)
        } else {
            handleDefaultDelimiter(input)
        }
    }

    private fun isCustomDelimiter(input: String): Boolean {
        return input.startsWith("//")
    }

    private fun handleCustomDelimiter(input: String): Int {
        val (customDelimiter, numbersPart) = extractCustomDelimiterAndNumbers(input)
        val delimitersRegex = createDelimiterRegex(customDelimiter)
        return splitAndSum(numbersPart, delimitersRegex)
    }

    private fun handleDefaultDelimiter(input: String): Int {
        val defaultDelimitersRegex = Regex("[,:]")
        return splitAndSum(input, defaultDelimitersRegex)
    }

    private fun extractCustomDelimiterAndNumbers(input: String): Pair<String, String> {
        val regex = Regex("//(.*)\n(.*)")
        val matchResult =
            regex.find(input)
                ?: throw RuntimeException("Invalid input format: $input")
        val customDelimiter = matchResult.groupValues[1]
        val numbersPart = matchResult.groupValues[2]
        return customDelimiter to numbersPart
    }

    private fun createDelimiterRegex(customDelimiter: String): Regex {
        return Regex("[${Regex.escape(customDelimiter)},:]")
    }

    private fun splitAndSum(
        numbersPart: String,
        delimitersRegex: Regex,
    ): Int {
        return numbersPart.split(delimitersRegex)
            .filter { it.isNotBlank() }.sumOf { validateAndParse(it) }
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
