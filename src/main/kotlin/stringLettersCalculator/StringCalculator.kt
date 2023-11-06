package stringLettersCalculator


class StringCalculator {

    fun calculate(inputMessage: String): Int {
        val splitKeyWord = splitKeyWord(inputMessage)
        return StringNumbers.from(splitKeyWord)
            .sumNumbers()
    }

    private fun splitKeyWord(inputMessage: String): List<String> {
        val delimiters = mutableListOf(",", ":")
        val result = Regex(CUSTOM_REGEX_PATTERN).find(inputMessage)

        result?.let { it ->
            val customDelimiter = it.groupValues[1]
            delimiters.add("\\" + customDelimiter)

            return splitByDelimiters(it.groupValues[2], delimiters)
        }
        return splitByDelimiters(inputMessage, delimiters)
    }

    private fun splitByDelimiters(
        inputMessage: String,
        delimiters: MutableList<String>
    ) = inputMessage.split(
        delimiters.joinToString("|")
            .toRegex()
    ).filter {
        it.isNotEmpty() || it.isNotBlank()
    }

    companion object {
        const val CUSTOM_REGEX_PATTERN = """//(.)\n(.*)"""
    }
}
