package calculator.separator

class DefaultSeparator : SeparatorPolicy {
    override fun canSeparate(expression: String?) =
        expression?.let {
            PATTERN.matchEntire(it) != null
        } ?: true


    override fun separate(expression: String?) =
        expression
            ?.split(",", ":")
            ?.toList()
            ?.filter { it.isNotBlank() }
            ?: emptyList()


    companion object {
        private val PATTERN = Regex("((.)+[:|,])*(.)|^\\s*$")
    }
}
