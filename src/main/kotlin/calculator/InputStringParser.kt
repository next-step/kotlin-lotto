package calculator

class InputStringParser(private val input: String) {

    fun getSeperatedValue(): List<Int> {
        val numbers = input
            .takeIf { it.isContainCustomDelimiter() }
            ?.let { splitByCustomDelimiter(input) }
            ?: input.split(DEFAULT_DELIMITER_REGEX).map { it.toInt() }
        negativeNumberValidate(numbers)
        return numbers
    }

    private fun String.isContainCustomDelimiter() = CUSTOM_DELIMITER_REGEX.matches(this)

    private fun splitByCustomDelimiter(input: String): List<Int> {
        CUSTOM_DELIMITER_REGEX.find(input)!!.let { matchResult ->
            return matchResult.groupValues[2].split(matchResult.groupValues[1]).map { it.toInt() }
        }
    }

    private fun negativeNumberValidate(numbers: List<Int>) {
        if (numbers.any { it < 0 }) throw InvalidInputNumberException()
    }

    companion object {
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
        private val DEFAULT_DELIMITER_REGEX = Regex("[:,]")
    }
}
