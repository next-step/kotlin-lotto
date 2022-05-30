package calculator.domain

class StringAddCalculator(
    private val separators: Separators = Separators(),
) {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val texts = separators.splitText(text = text)
        val positiveNumbers = PositiveNumbers.of(texts = texts)
        return positiveNumbers.sum().value
    }
}
