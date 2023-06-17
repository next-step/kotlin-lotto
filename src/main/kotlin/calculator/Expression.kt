package calculator

class Expression(val separators: List<String>, val numbers: List<PositiveOperand>) {

    companion object {
        val DEFAULT_SEPARATORS = arrayOf(",", ":")
        fun of(value: String): Expression {
            if (hasCustomSeparator(value)) {
                return withCustomSeparator(value)
            }
            return withDefaultSeparator(value)
        }

        private fun withCustomSeparator(value: String): Expression {
            val separator = value[2].toString()
            val positiveOperands = value.substring(4)
                .split(value[2].toString())
                .filter { it.isNotBlank() }
                .map(::PositiveOperand)
            return Expression(listOf(separator), positiveOperands)
        }

        private fun withDefaultSeparator(value: String): Expression {
            val positiveOperands = value.split(*DEFAULT_SEPARATORS)
                .filter { it.isNotBlank() }
                .map(::PositiveOperand)
            return Expression(DEFAULT_SEPARATORS.toList(), positiveOperands)
        }

        private fun hasCustomSeparator(value: String): Boolean {
            return value.startsWith("//") && value.substring(3).startsWith("\n")
        }
    }
}
