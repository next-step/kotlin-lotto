package calculator

class Calculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0

        val tokens = split(text)
        val numbers = tokens.map { it.toInt() }.toList()

        require(numbers.all { it >= 0 })

        return numbers.sum()
    }

    private fun split(text: String): List<String> {
        val result = CUSTOM_DELIMITER_REGEX.find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return text.split(DELIMITERS)
    }

    companion object {
        val DELIMITERS = "[,:]".toRegex()
        val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}
