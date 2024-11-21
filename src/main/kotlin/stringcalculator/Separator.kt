package stringcalculator

@JvmInline
value class Separator(private val value: String) {
    fun isEqual(inputValue: String) = this.value == inputValue
}
