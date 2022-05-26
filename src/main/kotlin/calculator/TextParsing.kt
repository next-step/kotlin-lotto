package calculator

object TextParsing {
    private const val CUSTOM_REGX = "//(.)\n(.*)"
    private const val DEFINED_REGX = ",|:"

    fun textParse(text: String) : List<Int> {
        return (getStringListWithCustomRegx(text) ?: getStringListWithDefinedRegx(text))
            .map { string -> string.toInt() }
    }

    private fun getStringListWithCustomRegx(text: String) : List<String>? {
        return Regex(CUSTOM_REGX).find(text)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }
    }

    private fun getStringListWithDefinedRegx(text: String) : List<String> {
        return text.split(Regex(DEFINED_REGX))
    }
}
