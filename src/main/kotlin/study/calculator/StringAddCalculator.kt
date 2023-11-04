package study.calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0

        val numbers = parseNumbers(text)
        return calculateSum(numbers)
    }

    private fun parseNumbers(text: String): List<String> =
        if (isCustomDelimiterFormat(text)) {
            val customDelimiter = extractCustomDelimiter(text)
            splitUsingCustomDelimiter(text, customDelimiter)
        } else {
            splitUsingDefaultDelimiters(text)
        }

    private fun isCustomDelimiterFormat(text: String): Boolean = text.startsWith("//")

    private fun extractCustomDelimiter(text: String): String = text.substring(
        2 until text.indexOf("\n")
    )

    private fun splitUsingCustomDelimiter(text: String, delimiter: String): List<String> {
        val numbersPart = text.substring(text.indexOf("\n") + 1)
        return numbersPart.split(delimiter)
    }

    private fun splitUsingDefaultDelimiters(text: String): List<String> = text.split(",", ":", "\n")

    private fun calculateSum(numbers: List<String>): Int = numbers.sumOf { numStr ->
        validateAndConvertToNumber(numStr)
    }

    private fun validateAndConvertToNumber(numStr: String): Int {
        val number = numStr.toIntOrNull() ?: throw RuntimeException("Invalid input: $numStr")
        validatePositive(number)
        return number
    }

    private fun validatePositive(number: Int) {
        if (number < 0) throw RuntimeException("Negatives not allowed: $number")
    }
}
