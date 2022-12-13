package lotto.extension

private const val NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력하세요 : [%s]"

fun String.toInt(): Int = this.toIntOrNull()
    ?: throw IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE.format(this))
