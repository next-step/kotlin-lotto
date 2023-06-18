package calculator

object StringCalculator {

    private val CUSTOM_PATTERN_REGEX = Regex("//(.)\n(.*)")
    private const val DELIMITER_INDEX = 1
    private const val TOKEN_INDEX = 2
    private const val DEFAULT_DELIMITER = ",|:"

    fun add(text: String?): Int {

        if (text.isNullOrEmpty()) {
            return 0
        }

        val groupValues = CUSTOM_PATTERN_REGEX.find(text)?.groupValues

        val delimiters = groupValues?.get(DELIMITER_INDEX) ?: DEFAULT_DELIMITER
        val tokens = groupValues?.get(TOKEN_INDEX) ?: text

        val numbers = tokens.split(delimiters.toRegex()).map {
            it.toIntOrNull().let { num ->
                require(num != null && num >= 0) {
                    "숫자 이외의 값 또는 음수를 전달하는 경우"
                }
                num
            }
        }

        return numbers.sum()
    }
}
