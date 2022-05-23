package calculator.domain

enum class Separator(
    val text: String
) {
    REST(","),
    COLON(":"),
    ;

    companion object {
        fun findByText(text: String) = values().find { it.text == text }
            ?: throw RuntimeException("'$text'는 문자열 덧셈 계산기 구분자가 아닙니다.")
    }
}
