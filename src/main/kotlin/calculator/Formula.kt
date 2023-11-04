package calculator

class Formula(formula: String?) {

    init {
        makeFormula(formula ?: "0")
    }

    private lateinit var operand: List<Operand>

    fun calculate(): Int {
        return operand.sumOf { it.getValue() }
    }

    private fun makeFormula(formula: String) {
        if (makeZeroWhenIsBlank(formula)) return
        val result = customDelimiterRegex.find(formula)

        result?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            operand = matchResult.groupValues[2].split(customDelimiter).map { Operand(it) }
            return
        }
        operand = formula.split(defaultDelimiter).map { Operand(it) }
    }

    private fun makeZeroWhenIsBlank(formula: String): Boolean {
        if (formula == "") {
            operand = listOf(Operand("0"))
            return true
        }
        return false
    }


    companion object {
        private val customDelimiterRegex = Regex("//(.)\n(.*)")
        private val defaultDelimiter = Regex(",|:")
    }
}
