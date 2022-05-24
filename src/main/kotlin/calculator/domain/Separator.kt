package calculator.domain

enum class Separator(
    private val regex: Regex,
    val split: (String) -> List<String>,
) {
    DEFAULT(
        Regex("[,:]"),
        { text -> text.split(DEFAULT.regex) }
    ),
    CUSTOM(
        Regex("//(.)\n(.*)"),
        { text ->
            val matchResult = CUSTOM.regex.matchEntire(text)!!
            matchResult.groupValues[2].split(matchResult.groupValues[1])
        }),
    ;

    companion object {
        fun matchByCustomSeparator(text: String): Boolean {
            return CUSTOM.regex.matches(text)
        }
    }
}
