package stringAddCalculator

object StringAddCalculator {
    private const val CUSTOM_DELIMITER =
        """//(.)\\n(.*)"""

    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.length == 1) return text.toInt()

        var targetText = text
        val delimiters = mutableListOf(",", ":")

        Regex(CUSTOM_DELIMITER).find(text)?.let {
            delimiters.add(it.groupValues[1])
            targetText = it.groupValues[2]
        }

        val texts = targetText.split(*delimiters.toTypedArray()).map {
            val number = it.toInt()
            if (number < 0) throw RuntimeException("can not use nagative number $number")
            number
        }

        return getTotal(texts)
    }

    private fun getTotal(texts: List<Int>) = texts.reduce { total, number -> total + number }
}
