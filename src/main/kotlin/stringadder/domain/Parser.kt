package stringadder.domain

private val PATTERN = Regex("//(.*)\\\\n(.*)")

object Parser {
    fun parse(read: String): Expression {
        if (PATTERN.matches(read)) {
            return Expression(Delimiters(PATTERN.find(read)!!.groupValues[1]), PATTERN.find(read)!!.groupValues[2])
        }
        return Expression(Delimiters(), read)
    }
}