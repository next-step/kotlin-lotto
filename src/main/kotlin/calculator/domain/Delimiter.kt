package calculator.domain

enum class Delimiter(
    val value: String
) {
    COMMA(","), COLON(":");

    companion object {
        fun find(literalValue: String): Delimiter = values().find { it.value == literalValue } ?: throw IllegalArgumentException("존재하지 않는 구분자입니다.")
    }
}
