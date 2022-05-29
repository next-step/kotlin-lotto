package calculator.domain

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val positiveNumbers = PositiveNumbers.of(splitTextByPattern(text))
        return positiveNumbers.sum().value
    }

    private fun splitTextByPattern(text: String): List<String> =
        when (Separator.matchByCustomSeparator(text)) {
            true -> Separator.CUSTOM.split(text)
            false -> Separator.DEFAULT.split(text)
        }
}
