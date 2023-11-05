class StringAddCalculator {
    fun add(text: String?): Int {
        text ?: return 0
        if (text.isEmpty()) {
            return 0
        }

        if (text.matches(Regex("//(.)\n(.*)"))) {
            val customDelimiter = text[2]
            val numbers = text.substring(4).split(customDelimiter)
            return numbers.sumOf { it.toInt() }
        }

        val numbers = text.split("[,|:]".toRegex())

        return numbers.sumOf { it.toInt() }
    }
}
