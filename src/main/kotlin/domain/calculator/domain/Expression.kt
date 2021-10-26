package domain.calculator.domain

@JvmInline
value class Expression(private val _expression: String?) {

    val expression: String
        get() {
            if (_expression.isNullOrBlank()) {
                return DEFAULT_STRING
            }
            return _expression
        }

    companion object {
        const val DEFAULT_STRING = "0";
    }
}