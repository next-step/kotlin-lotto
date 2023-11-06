package stringaddcalculator

class StringAddCalculator {
    fun calculate(input: String?): Int {
        val validInput = input.takeUnless { it.isNullOrBlank() } ?: return 0
        val numbers: List<Int> = getIntegersFromInput(validInput)
        numbers.firstOrNull { it < 0 }?.let { throw RuntimeException("음수는 입력할 수 없습니다.") }
        return numbers.sum()
    }

    private fun getIntegersFromInput(input: String): List<Int> =
        if (input.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.matchEntire(input)
            val (delimiter, numbers) = matchResult?.destructured ?: throw IllegalArgumentException("잘못된 입력입니다. $input")
            numbers.split(delimiter).map { it.toInt() }
        } else {
            input.split(*DEFAULT_DELIMITERS).map { it.toInt() }
        }

    companion object {
        private val CUSTOM_DELIMITER_REGEX: Regex = "//(.)\\n(.+)".toRegex()
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}