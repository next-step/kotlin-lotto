package calculator.separator

class CustomSeparator : SeparatorPolicy {
    override fun canSeparate(expression: String?): Boolean {
        return expression?.let {
            PATTERN.find(it) != null
        } ?: false
    }

    override fun separate(expression: String?) = expression?.let {
        PATTERN.find(it)
    }?.let {
        val customDelimiter = it.groupValues[1]
        it.groupValues[2].splitToList(customDelimiter)
    } ?: emptyList()

    private fun String.splitToList(delimiter: String) = split(delimiter).toList()

    companion object {
        private val PATTERN = Regex("//(.)\\\\n(.*)")
    }
}
