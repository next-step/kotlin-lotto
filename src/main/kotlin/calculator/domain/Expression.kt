package calculator.domain

private const val EMPTY_VALUE = "0"
private val defaultRegex = "[,:]".toRegex()
private val customRegex = Regex("//(.)\n(.*)")

object Expression {
    fun split(text: String?): List<String> {
        if (text.isNullOrBlank()) {
            return emptyList()
        }

        val result = customRegex.find(text)

        return result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: text.split(defaultRegex)
    }
}
