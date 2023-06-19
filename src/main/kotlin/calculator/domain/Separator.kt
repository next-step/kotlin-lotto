package calculator.domain

@JvmInline
value class Separator(
    val separator: String
) {
    companion object {
        fun create(text: String): Separator {
            val regexResult = Regex("//(.)\n(.*)").find(text)
            val customSeparator = regexResult?.let {
                it.groupValues[1]
            }
            return Separator(customSeparator.toString())
        }
    }
}
