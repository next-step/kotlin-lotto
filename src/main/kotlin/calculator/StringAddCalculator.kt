package calculator

object StringAddCalculator {
    private val DELIMITERS = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0

        val tokens = text.split()
        val numbers = tokens.map { it.toNonNegative() }

        return numbers.sum()
    }

    private fun CharSequence.split(): List<String> {
        val result = CUSTOM_DELIMITER_REGEX.find(this)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return this.split(DELIMITERS)
    }

    private fun String.toNonNegative(): Int {
        return this.toIntOrNull()?.takeIf { it >= 0 } ?: throw IllegalArgumentException()
    }
}
