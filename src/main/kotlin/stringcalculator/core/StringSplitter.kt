package stringcalculator.core

class StringSplitter(private val token: String, private val customDelimiter: String = "") {
    fun split(): List<String> {
        return token.split(Regex(makeDelimiterRegex()))
    }

    private fun makeDelimiterRegex(): String {
        return listOf(",", ";", customDelimiter).joinToString("", "[", "]")
    }
}
