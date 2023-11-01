package stringcalculator

@JvmInline
value class Number(val value: Int) {
    init {
        NumberValidator.negativeValidate(value)
    }
}
