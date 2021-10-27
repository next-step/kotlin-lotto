package calculator

class StringAddCalculator {

    private val splitHelper = SplitHelper()

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val positiveNumbers = splitHelper
            .split(text)
            .map { it.toInt() }
            .let(::PositiveNumbers)
        return positiveNumbers.sum()
    }
}
