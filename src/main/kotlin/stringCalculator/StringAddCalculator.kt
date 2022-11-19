package stringCalculator

class StringAddCalculator {
    fun sum(inputValue: String?): Int {
        if (inputValue.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val stringList = split(inputValue)
        validateNumber(stringList)

        return sum(stringList)
    }

    private fun split(string: String): List<String> {
        return string.split(DEFAULT_DELIMITER_REGEX)
    }

    private fun sum(stringList: List<String>) = stringList.sumOf { it.toInt() }

    companion object {
        private const val DEFAULT_VALUE = 0

        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")

        private val POSITIVE_INTEGER_REGEX = Regex("\\+?[0-9]+")

        private fun validateNumber(strings: List<String>) {
            strings.forEach {
                require(it.matches(POSITIVE_INTEGER_REGEX)) { "숫자가 아닌 값 혹은 음수를 입력하였습니다. (입력값:$it)" }
            }
        }
    }
}