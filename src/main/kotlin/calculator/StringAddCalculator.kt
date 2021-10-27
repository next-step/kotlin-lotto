package calculator

class StringAddCalculator {

    private val splitHelper = SplitHelper()

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val splitText = splitHelper.split(text)
        val positiveNumbers = PositiveNumbers.from(splitText)
        return positiveNumbers.sum()
    }
}
