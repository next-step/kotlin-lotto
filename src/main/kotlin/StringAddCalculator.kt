class StringAddCalculator {
    fun add(text: String?): Int {
        text ?: return 0
        if (text.isEmpty()) {
            return 0
        }

        val numbers = splitWithDelimiter(text)

        return numbers.sumOf { toPositiveInt(it) }
    }

    private fun splitWithDelimiter(text: String): List<String> {
        if (text.matches(Regex("//(.)\n(.*)"))) {
            val customDelimiter = text[2]
            return text.substring(4).split(customDelimiter)
        }
        return text.split("[,|:]".toRegex())
    }

    private fun toPositiveInt(text: String): Int {
        val number = text.toInt()
        if (number < 0) {
            throw RuntimeException()
        }
        return number
    }
}
