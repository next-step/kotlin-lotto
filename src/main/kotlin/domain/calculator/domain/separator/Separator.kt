package domain.calculator.domain.separator

@JvmInline
value class Separator(val separator: String) {
    init {
        if (separator.isNullOrBlank()) throw RuntimeException("Separator, null 이거나 공백인 문자열은 입력할 수 없습니다.")
    }
}
