package stringcalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        if (text.length == 1) return checkInt(text).toInt()
        return splitText(text)
    }

    private fun splitText(text: String): Int {
        val tokens = text.split(",", ":")
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            val regxToken = it.groupValues[2].split(customDelimiter)
            resultSum(regxToken)
        } ?: resultSum(tokens)
    }

    private fun negativeCheck(number: String): String {
        return if (number.toInt() < 0) throw RuntimeException("$number is negative")
        else number
    }

    private fun checkInt(text: String): String {
        return if (text.toInt().toString() != text) throw IllegalArgumentException("숫자만 입력이 가능합니다.")
        else negativeCheck(text)
    }

    private fun resultSum(inputNumbers: List<String>): Int {
        inputNumbers.forEach { inputNumber -> checkInt(inputNumber) }
        return inputNumbers.map { it.toInt() }.sum()
    }
}
