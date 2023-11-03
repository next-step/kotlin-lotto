package stringAddCalculator

@JvmInline
value class CalculatorDelimiter(val value: String?) {
    fun getDelimiter() = ",|:${if (value.isNullOrBlank()) "" else "|$value"}"
}
