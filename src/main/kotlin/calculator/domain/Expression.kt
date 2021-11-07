package calculator.domain

data class Expression(val delimiter: Delimiter = Delimiter.DEFAULT_DELIMITER, val operands: Operands) {

    companion object {
        private val pattern = Regex("//(.)\n(.*)")

        fun of(input: String): Expression {
            pattern.find(input)?.let {
                val delimiter = Delimiter.of(it.groupValues[1])
                val operands = Delimiter.getOperands(delimiter, it.groupValues[2])
                return Expression(delimiter, operands)
            }
            return Expression(operands = Delimiter.getOperands(Delimiter.DEFAULT_DELIMITER, input))
        }
    }
}
