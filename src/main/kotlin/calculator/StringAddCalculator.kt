package calculator

class StringAddCalculator {

    fun calculate(stringNumbers: String): Int {
        val stringNumberCollection = StringNumberCollection(
            split(stringNumbers).map { StringNumber(it) }
        )

        return stringNumberCollection.add()
    }

    private fun split(input: String): List<String> {
        return input.split(DEFAULT_REGEX)
    }

    companion object {
        private const val DEFAULT_DELIMITERS = "[,;]"
        private val DEFAULT_REGEX = Regex(DEFAULT_DELIMITERS)
    }
}
