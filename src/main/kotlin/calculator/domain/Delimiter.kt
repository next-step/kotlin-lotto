package calculator.domain

@JvmInline
value class Delimiter(val symbol: String) {

    companion object {
        private const val DEFAULT_SYMBOL = ",|:"

        val DEFAULT_DELIMITER = Delimiter(DEFAULT_SYMBOL)

        fun of(symbol: String?): Delimiter {
            if (symbol.isNullOrEmpty()) return DEFAULT_DELIMITER
            return Delimiter(symbol)
        }
    }
}
