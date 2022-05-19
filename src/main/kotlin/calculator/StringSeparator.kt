package calculator

object StringSeparator {
    private const val DEFAULT_DELIMITER = ","
    private val CUSTOM_REGEX = Regex("//(.)\n(.*)")
    private val DEFAULT_NUMBER = listOf(PositiveNumber(0))

    fun separate(inputString: String?): List<PositiveNumber> {
        if (inputString.isNullOrEmpty()) {
            return DEFAULT_NUMBER
        }

        return CUSTOM_REGEX.find(inputString)
            ?.let { toPositiveNumbers(inputString = it.groupValues[2], delimiter = it.groupValues[1]) }
            ?: toPositiveNumbers(inputString, DEFAULT_DELIMITER)
    }

    private fun toPositiveNumbers(inputString: String, delimiter: String): List<PositiveNumber> = inputString.split(delimiter)
        .map {
            it.toIntOrNull()?.let { intValue -> PositiveNumber(intValue) }
                ?: throw IllegalArgumentException("숫자가 아닌경우 입력될수 없습니다.")
        }
}
