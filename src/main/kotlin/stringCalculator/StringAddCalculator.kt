package stringCalculator

class StringAddCalculator {
    fun sum(inputValue: String?): Int {
        if (inputValue.isNullOrBlank()) {
            return DEFAULT_VALUE
        }
        val stringList = split(inputValue)

        TODO("구현예정")
    }

    private fun split(string: String): List<String> {
        return string.split(DEFAULT_DELIMITER_REGEX)
    }

    companion object {
        private const val DEFAULT_VALUE = 0

        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    }
}