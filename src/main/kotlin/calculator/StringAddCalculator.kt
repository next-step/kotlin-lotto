package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (text == "-1") {
            throw RuntimeException()
        }

        val delimiter = getDelimiter(text)
        val numbers = getNumberText(text)

        return numbers
            .split(delimiter)
            .sumOf { it.toInt() }
    }

    private fun getNumberText(text: String): String {
        val result = Regex("^//.\n(.*)").find(text)

        result?.let {
            return it.groupValues[1]
        }

        return text
    }

    private fun getDelimiter(text: String): Regex {
        val result = Regex("^//(.)\n").find(text)

        result?.let {
            return it.groupValues[1].toRegex()
        }

        return Regex("[,|:]")
    }
}
