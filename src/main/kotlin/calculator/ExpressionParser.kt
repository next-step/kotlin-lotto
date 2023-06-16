package calculator

class ExpressionParser(val inputExpression: String) {
    var customSeperator: Array<String>
        private set

    var numberString: String = ""
        private set

    private fun getCustomSeperator(inputExpression: String): String {
        val matchResult = CUSTOM_SEPERATOR_EXPRESSION_REGEX.find(inputExpression) ?: return ""
        return matchResult.groupValues[1]
    }

    private fun getArrayBasedOnInput(inputExpression: String): Array<String> {
        val customSeperator = getCustomSeperator(inputExpression)
        return if (customSeperator.isNotEmpty()) {
            arrayOf(",", ":", customSeperator[0].toString())
        } else {
            arrayOf(",", ":")
        }
    }

    init {
        customSeperator = getArrayBasedOnInput(inputExpression)
        numberString = CUSTOM_SEPERATOR_EXPRESSION_REGEX.replace(inputExpression, "")
    }

    companion object {
        private val CUSTOM_SEPERATOR_EXPRESSION_REGEX = Regex("""\/\/(.+?)\n""")
    }
}
