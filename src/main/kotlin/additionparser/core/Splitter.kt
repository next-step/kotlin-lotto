package additionparser.core

class Splitter(private val token: String, private val customDelimiter: String = "") {
    fun split(): List<String> {
        return token.split(Regex(getPattern()))
    }

    private fun getPattern(): String {
        val strBuilder = StringBuilder()
        strBuilder.append("[,;")
        strBuilder.append(customDelimiter)
        strBuilder.append("]")

        return strBuilder.toString()
    }
}
