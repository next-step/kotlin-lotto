package stringcalculator.view

object InputView {
    private const val ZERO_VALUE = "0"

    fun input(): String {
        val inputValue = readLine() ?: throw IllegalArgumentException("")
        if(inputValue.isNullOrBlank()) return ZERO_VALUE
        return inputValue
    }
}
