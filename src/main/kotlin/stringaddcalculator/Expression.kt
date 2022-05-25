package stringaddcalculator

class Expression(private val expression: String?) {
    fun parse(): List<Int> {
        if (expression.isNullOrBlank())
            return listOf(0)

        val result = CUSTOM_REGEX.toRegex().find(expression)
        val operandString = getOperandString(result, default = expression)
        val delimiter = result.getGroupValue(2)?.run { "[$this,:]" } ?: DEFAULT_DELIMITER

        return operandString
            .split(Regex(delimiter))
            .checkOperandIsNum()
            .map { it.trim().toInt() }
            .checkOperandIsMoreThanZero()
    }

    private fun getOperandString(result: MatchResult?, default: String): String {
        var tempString = ""
        result.getGroupValue(1)?.let {
            tempString += it
        }
        result.getGroupValue(3)?.let {
            tempString += it
        }
        if (tempString.isEmpty())
            tempString = default

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

    companion object {
        private const val DEFAULT_DELIMITER = "[,:]"
        private const val CUSTOM_REGEX = """(.*)//(.)\\n(.*)"""
    }
}
