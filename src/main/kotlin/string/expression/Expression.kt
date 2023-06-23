package string.expression

class Expression(
    private val tokens: List<Int>,
) {
    fun sum(): Int {
        return tokens.sum()
    }
}
