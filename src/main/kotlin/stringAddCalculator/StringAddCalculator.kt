package stringAddCalculator

object StringAddCalculator {
    private const val CUSTOM_DELIMITER =
        """//(.)\\n(.*)"""
    private const val ZERO = 0
    private val delimiters = mutableListOf(",", ":")

    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.length == 1) return text.toInt()

        var targetText = Regex(CUSTOM_DELIMITER).find(text)?.let {
            delimiters.add(it.groupValues[1])
            it.groupValues[2]
        } ?: text

        val numbers = getNumbers(targetText, delimiters)

        return getTotal(numbers)
    }

    private fun getNumbers(
        targetText: String,
        delimiters: MutableList<String>
    ): List<Int> {
        return targetText.split(*delimiters.toTypedArray()).map { str ->
            str.toInt().also { number ->
                if (isNegativeNumber(number)) throw RuntimeException("can not use nagative number $number")
            }
        }
    }

    private fun isNegativeNumber(number: Int) = number < ZERO

    private fun getTotal(texts: List<Int>) = texts.reduce { total, number -> total + number }
}
