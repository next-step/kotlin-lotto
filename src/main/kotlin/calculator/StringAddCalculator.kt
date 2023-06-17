package calculator

class StringAddCalculator {

    fun calculate(stringNumbers: String): Int {
        val stringNumberCollection = StringNumberCollection(
            split(stringNumbers).map { StringNumber(it) }
        )

        return stringNumberCollection.add()
    }

    private fun split(input: String): List<String> {
        return splitByCustomDelimiterOrNull(input) ?: input.split(DEFAULT_REGEX)
    }

    private fun splitByCustomDelimiterOrNull(input: String): List<String>? {
        return Regex("//(.)\n(.*)").find(input)?.let {
            val delimiter = it.groupValues[1]
            val stringNumbers = it.groupValues[2].split(delimiter)
            stringNumbers
        }
    }

    companion object {
        private const val DEFAULT_DELIMITERS = "[,:]"
        private val DEFAULT_REGEX = Regex(DEFAULT_DELIMITERS)
    }
}
