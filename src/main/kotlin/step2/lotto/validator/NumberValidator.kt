package step2.lotto.validator

object NumberValidator {
    private const val NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력하세요 : [%s]"

    fun toInt(input: String) =
        input.toIntOrNull() ?: throw IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE.format(input))
}
