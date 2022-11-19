import utils.findPattern

object DelimiterExtractor {
    fun run(expression: String): String? {
        val result = expression.findPattern()
        return result?.let { it.groupValues[1] }
    }
}
