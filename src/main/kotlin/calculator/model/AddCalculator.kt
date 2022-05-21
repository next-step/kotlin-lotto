package calculator.model

object AddCalculator {
    private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return input.split(DEFAULT_DELIMITER_REGEX)
            .map { Number.from(it.toInt()) }
            .sumOf { it.number }
    }
}
