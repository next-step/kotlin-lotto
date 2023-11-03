package calculator

object StringAddCalculator {
    private const val DELIMITERS = "[,:]"

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val customResult = Regex("//(.)\n(.*)").find(text)

        customResult?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val numbers = matchResult.groupValues[2].split(customDelimiter)

            return numbers.sumOf { it.toInt() }
        }

        val numbers = text.split(DELIMITERS.toRegex())

        return numbers.sumOf { it.toInt() }
    }
}
