package stringAddCalculator

object StringAddCalculator {

    private const val delimiterPattern = "//(.)\n(.*)"

    fun evaluate(formula: String?): Int {
        if (formula.isNullOrBlank()) return 0

        val result = Regex(delimiterPattern).find(formula)?.groupValues

        val customDelimiter = CalculatorDelimiter(result?.get(1))

        val numbers = formula
            .replace("//${customDelimiter.value}\n".toRegex(), "")
            .split(customDelimiter.getDelimiter().toRegex())
            .map { CalculatorToken(it).convertOrThrow(formula, customDelimiter.getDelimiter()) }

        return numbers.sum()
    }
}
