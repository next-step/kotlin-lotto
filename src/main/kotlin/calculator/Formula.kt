package calculator

class Formula(input: String) {
    private val operands: List<Operand>

    init {
        val customDelimiterAndOperands = input.split("\n")
        val customDelimiter: String? = getCustomDelimiter(customDelimiterAndOperands)
        operands = stringFormulaToOperand(customDelimiterAndOperands.last(), customDelimiter)
    }

    fun sumValues(): Int = operands.sumOf { it.value }

    private fun getCustomDelimiter(customDelimiterAndOperands: List<String>): String? {
        if (customDelimiterAndOperands.size == 2)
            return customDelimiterAndOperands.first().removeRange(0..1)
        return null
    }

    private fun stringFormulaToOperand(input: String, customDelimiter: String?) =
        stringFormulaToStringValues(input, customDelimiter).map { Operand(it) }

    private fun stringFormulaToStringValues(input: String, customDelimiter: String?) =
        customDelimiter?.let { splitInputOperand(input, it) }
            ?: splitInputOperand(input)

    private fun splitInputOperand(input: String, vararg delimiters: String = DEFAULT_DELIMITERS): List<String> =
        input.split(*delimiters)

    companion object {
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}
