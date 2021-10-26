package domain.calculator.domain.separator

@JvmInline
value class Separator(val separator: String) {
    init {
        if (separator.isNullOrBlank()) throw RuntimeException(NULL_OR_BLANK_EXCEPTION_MESSAGE)
    }

    companion object {
        const val DEFAULT_SEPARATOR_COMMA = ","
        const val DEFAULT_SEPARATOR_COLON = ":"

        private const val NULL_OR_BLANK_EXCEPTION_MESSAGE = "Separator, null 이거나 공백인 문자열은 입력할 수 없습니다."
    }
}
