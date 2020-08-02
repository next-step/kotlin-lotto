package stringAddCalculator

object StringAddCalculator {
    private const val CUSTOM_DELIMITER =
        """//(.)\\n(.*)"""
    const val ZERO = 0
    private val delimiters = mutableListOf(",", ":")
    private val regex = Regex(CUSTOM_DELIMITER)

    fun add(text: String): Number {
        if (text.isBlank()) return Number(ZERO)
        if (text.length == 1) return Number(text.toInt())
        val targetText = getTargetText(text)
        val numbers = getNumbers(targetText)
        return getTotal(numbers)
    }

    private fun getTargetText(text: String): String {
        return regex.find(text)?.let {
            delimiters.add(it.groupValues[1])
            it.groupValues[2]
        } ?: text
    }

    private fun getNumbers(targetText: String): List<Number> {
        val strList = targetText.split(*delimiters.toTypedArray())
        return toIntList(strList)
    }

    private fun toIntList(values: List<String>): List<Number> {
        return values.map { value ->
            Number(value.toInt())
        }
    }

    private fun getTotal(texts: List<Number>) = texts.reduce { total, number -> total.plus(number) }
}
