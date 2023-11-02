package stringAddCalculator

@JvmInline
value class CalculatorDelimiter(private val _value: String?) {
    val value get() = _value
    fun getDelimiter() = ",|:${if (_value.isNullOrBlank()) "" else "|$_value"}"
}
