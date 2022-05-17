package calcaulator

data class CalculatorInput(val numberInputString: String, val delimiter: Regex) {
    fun toNumberTokenList() = this.numberInputString
        .split(delimiter)
        .map { it.toInt() }
}
