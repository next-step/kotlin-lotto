package calculator.domain

@JvmInline
value class Delimiter(val symbol: String) {

    companion object {
        private const val DEFAULT_SYMBOL = ",|:"

        val DEFAULT_DELIMITER = Delimiter(DEFAULT_SYMBOL)

        private fun isDefaultDelimiter(delimiter: Delimiter): Boolean {
            return delimiter == DEFAULT_DELIMITER
        }

        fun of(symbol: String?): Delimiter {
            if (symbol.isNullOrEmpty()) {
                return DEFAULT_DELIMITER
            }
            return Delimiter(symbol)
        }

        fun getOperands(delimiter: Delimiter, input: String?): Operands {
            if (isDefaultDelimiter(delimiter)) {
                return Operands.of(input!!.split(Regex(delimiter.symbol)))
            }
            return Operands.of(input?.split(delimiter.symbol) ?: listOf())
        }
    }
}
