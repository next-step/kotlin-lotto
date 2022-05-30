package calculator.domain

sealed interface Separator {
    fun split(text: String): List<String>

    fun isMatchWithText(text: String): Boolean
}

object Default : Separator {
    override fun split(text: String): List<String> = text.split(Regex(pattern = "[,:]"))

    override fun isMatchWithText(text: String): Boolean = false
}

object Custom : Separator {
    private val regex: Regex = Regex(pattern = "//(.)\n(.*)")

    override fun split(text: String): List<String> {
        val matchResult = regex.matchEntire(text)!!
        return matchResult.groupValues[2].split(matchResult.groupValues[1])
    }

    override fun isMatchWithText(text: String): Boolean = regex.matches(text)
}
