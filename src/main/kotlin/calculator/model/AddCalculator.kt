package calculator.model

object AddCalculator {
    private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val numbers = input.split(DEFAULT_DELIMITER_REGEX)
        return Numbers.from(numbers).sum()
    }
}
