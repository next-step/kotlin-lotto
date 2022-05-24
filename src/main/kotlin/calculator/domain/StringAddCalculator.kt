package calculator.domain

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val regex = Separator.toRegexWith("|")
        val positiveNumbers = PositiveNumbers.of(text.split(regex = regex))
        return positiveNumbers.addAll().value
    }
}
