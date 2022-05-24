package calculator.domain

enum class Separator(
    val text: String,
) {
    REST(","),
    COLON(":"),
    ;

    companion object {
        fun toRegexWith(separatorValue: String) = values()
            .joinToString(separator = separatorValue)
            .toRegex()
    }
}
