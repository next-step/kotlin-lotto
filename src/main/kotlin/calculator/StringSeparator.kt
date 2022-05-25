package calculator

object StringSeparator {

    private const val DEFAULT_DELIMITER = ",|:"
    private val CUSTOM_REGEX = Regex("//(.)\n(.*)")
    private val DEFAULT_NUMBER = PositiveNumbers(listOf(PositiveNumber(0)))

    fun separate(inputString: String?): PositiveNumbers {
        if (inputString.isNullOrEmpty()) {
            return DEFAULT_NUMBER
        }

        return CUSTOM_REGEX.find(inputString)
            ?.let { toPositiveNumbers(inputString = it.groupValues[2], delimiter = it.groupValues[1]) }
            ?: toPositiveNumbers(inputString)
    }

    private fun toPositiveNumbers(
        inputString: String,
        delimiter: String = DEFAULT_DELIMITER
    ): PositiveNumbers = inputString.split(delimiter.toRegex())
        .map {
            it.toIntOrNull()?.let { intValue -> PositiveNumber(intValue) }
                ?: throw IllegalArgumentException("숫자가 아닌경우 변환할수 없습니다.")
        }.let(::PositiveNumbers)
}
