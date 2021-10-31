package calculator

class Formula(input: String) {
    private val operands: List<Operand>

    init {
        var customDelimiter: String? = null
        val customDelimiterAndOperands = input.split("\n")
        if (customDelimiterAndOperands.size == 2)
            customDelimiter = customDelimiterAndOperands.first().removeRange(0..1)
        operands = stringFormulaToOperand(customDelimiterAndOperands.last(), customDelimiter)
    }

    fun sumValues(): Int = operands.sumOf { it.value }

    private fun stringFormulaToOperand(input: String, customDelimiter: String?) =
        stringFormulaToStringValues(input, customDelimiter).map { Operand(it) }

    private fun stringFormulaToStringValues(input: String, customDelimiter: String?) =
        customDelimiter?.let { splitInputOperand(input, it) }
            ?: splitInputOperand(input)

    private fun splitInputOperand(input: String, vararg delimiters: String = arrayOf(",", ":")): List<String> =
        input.split(*delimiters)
}
