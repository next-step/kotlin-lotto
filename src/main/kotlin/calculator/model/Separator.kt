package calculator.model

enum class Separator(
    private val separator: SepartorStrategy
) {

    DEFAULT_SEPARATOR(DefaultSeparator),
    CUSTOM_SEPARATOR(CustomSeparator);

    companion object {
        fun separate(input: String): List<String> {
            val separator = values().find { it.separator.isSeparable(input) }

            require(separator != null) { "분리할 수 없는 인풋입니다. (input: $input)" }

            return separator.separator.separate(input)
        }
    }
}
