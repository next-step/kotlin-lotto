package calcaulator

data class CalculatorInput(val numberInputString: String, val delimiter: Regex) {
    fun toNumberTokenList(): List<Int> {
        val numberTokenList = this.numberInputString
            .split(delimiter)
            .filter { it.isNotBlank() }
            .map { it.trim().toInt() }

        if (numberTokenList.isEmpty()) {
            return listOf(0)
        }
        return numberTokenList
    }
}
