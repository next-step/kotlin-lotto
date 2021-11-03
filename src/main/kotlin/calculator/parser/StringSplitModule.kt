package calculator.parser

class StringSplitModule {

    private val regex = Regex("//(.)\n(.*)")

    fun split(text: String): List<Int> {
        val result = regex.find(text)
        result?. let {
            val customDelimiter = it.groupValues[1]
            val numberList = it.groupValues[2].split(customDelimiter)
            return numberList.map { str: String -> str.toPositiveNumber() }
        }
        return defaultDelimiter(text)
    }

    private fun defaultDelimiter(text: String): List<Int> {
        return text.split(*DEFAULT_DELIMITER).map { it.toPositiveNumber() }
    }

    private fun String.toPositiveNumber(): Int {
        val number = this.trim().toInt()
        if (number < MIN_NUM) throw RuntimeException(OUT_OF_RANGE)
        return number
    }

    companion object {
        val DEFAULT_DELIMITER = arrayOf(",", ":")
        const val MIN_NUM: Int = 0
        const val OUT_OF_RANGE: String = "음수를 입력하실수 없습니다."
    }
}
