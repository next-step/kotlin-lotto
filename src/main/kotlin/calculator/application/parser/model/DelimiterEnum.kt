package calculator.application.parser.model

enum class DelimiterEnum(
    override val value: String
) : Delimiter {
    COMMA(","), COLON(":");

    companion object {
        fun valuesStringArray() = values().map { it.value }.toTypedArray()
    }
}
