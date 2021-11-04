package calculator.parser

object StringSplitModule {

    private val customDelimiterRegex = Regex("//(.)\n(.*)")
    private val DEFAULT_DELIMITER = arrayOf(",", ":")
    private const val MIN_NUM: Int = 0
    private const val OUT_OF_RANGE: String = "음수를 입력하실수 없습니다."

    fun split(text: String): List<Int> {
        val result = customDelimiterRegex.find(text)
        result?. let {
            val customDelimiter = it.groupValues[1]
            val numberList = it.groupValues[2].split(customDelimiter)

            return numberList
                .map { listValue -> toPositiveNumber(listValue) }
        }
        return defaultDelimiter(text)
    }

    private fun defaultDelimiter(text: String): List<Int> {
        return text
            .split(*DEFAULT_DELIMITER)
            .map { toPositiveNumber(it) }
    }

    private fun toPositiveNumber(text: String): Int {
        val number = text.trim().toInt()
        if (number < MIN_NUM) throw RuntimeException(OUT_OF_RANGE)
        return number
    }
}
