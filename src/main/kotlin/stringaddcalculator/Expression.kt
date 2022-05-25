package stringaddcalculator

class Expression(private val expression: String?) {
    fun parse(): List<Int> {
        if (expression.isNullOrBlank())
            return listOf(0)

        val result = CUSTOM_REGEX.find(expression)
        val operandString = getOperandString(result) ?: expression
        val delimiter = result.getGroupValue(2)?.run { "[$this,:]" }?.checkOperatorIsNotNumber() ?: DEFAULT_DELIMITER

        return operandString
            .split(Regex(delimiter))
            .checkOperandIsNum()
            .map { it.trim().toInt() }
            .checkOperandIsMoreThanZero()
    }

    private fun getOperandString(result: MatchResult?): String? {
        var tempString: String? = buildString {
            append(result.getGroupValue(1) ?: "")
            append(result.getGroupValue(3) ?: "")
        }

        if (tempString?.length == 0)
            tempString = null

        return tempString
    }

    private fun MatchResult?.getGroupValue(i: Int): String? {
        return this?.groupValues?.get(i)
    }

    private fun List<String>.checkOperandIsNum(): List<String> {
        require(this.all { it.toIntOrNull() != null })
        return this
    }

    private fun List<Int>.checkOperandIsMoreThanZero(): List<Int> {
        require(this.all { it >= 0 })
        return this
    }

    private fun String.checkOperatorIsNotNumber(): String {
        require(this.toIntOrNull() == null)
        return this
    }

    companion object {
        private const val DEFAULT_DELIMITER = "[,:]"
        private val CUSTOM_REGEX = """(.*)//(.)\\n(.*)""".toRegex()
    }
}
