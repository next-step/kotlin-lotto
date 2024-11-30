package additioncalculator.domain

object StringAddCalculator {
    fun add(textOrNull: String?): Int {
        val textSplitToNumbers: List<Int> = NumberSplit.textSplitToNumbers(textOrNull = textOrNull)
        if (textSplitToNumbers.isEmpty()) {
            return DEFAULT_SUM_VALUE
        }
        return textSplitToNumbers.sum()
    }

    private const val DEFAULT_SUM_VALUE: Int = 0
}
