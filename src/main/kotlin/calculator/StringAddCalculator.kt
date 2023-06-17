package calculator

class StringAddCalculator {

    fun calculate(stringNumbers: String?): Int {
        if (stringNumbers.isNullOrBlank()) {
            return 0
        }

        val stringNumberCollection = StringNumberCollection(
            split(stringNumbers).map { StringNumber(it) }
        )

        return stringNumberCollection.add()
    }

    private fun split(stringNumbers: String): List<String> {
        return splitByCustomDelimiterOrNull(stringNumbers) ?: stringNumbers.split(DEFAULT_REGEX)
    }

    private fun splitByCustomDelimiterOrNull(stringNumbers: String): List<String>? {
        return Regex("//(.)\n(.*)").find(stringNumbers)?.let {
            val delimiter = it.groupValues[1]
            it.groupValues[2].split(delimiter)
        }
    }

    companion object {
        private const val DEFAULT_DELIMITERS = "[,:]"
        private val DEFAULT_REGEX = Regex(DEFAULT_DELIMITERS)
    }
}
