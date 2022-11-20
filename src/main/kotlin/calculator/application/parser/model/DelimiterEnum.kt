package calculator.application.parser.model

enum class DelimiterEnum(
    override val value: String
) : Delimiter {
    COMMA(","), COLON(":");

    companion object {
        fun find(literalValue: String): DelimiterEnum = values().find { it.value == literalValue } ?: throw IllegalArgumentException("존재하지 않는 구분자입니다.")
        fun valuesStringArray() = values().map { it.value }.toTypedArray()
    }
}
