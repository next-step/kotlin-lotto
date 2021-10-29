package calculator.domain

data class Expression(val delimiter: Delimiter, val operands: Operands) {

    companion object {
        private val pattern = Regex("//(.)\n(.*)")

        fun of(input: String): Expression {
            val delimiter = Delimiter.of(pattern.find(input)?.let { it.groupValues[1] })
            val operands = getOperands(delimiter, input)
            return Expression(delimiter, operands)
        }

        private fun getOperands(delimiter: Delimiter, input: String): Operands {
            if (delimiter == Delimiter.DEFAULT_DELIMITER) {
                return Operands.of(input.split(Regex(delimiter.symbol)))
            }
            return Operands.of(pattern.find(input)?.let { it.groupValues[2] }?.split(delimiter.symbol) ?: listOf())
        }
    }
}
