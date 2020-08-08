package stringcalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        if (text.length == 1) checkInt(text)
        return if (regexSplit(text) == -1) {
            splitText(text)
        } else regexSplit(text)
    }

    private fun splitText(text: String): Int {

        val tokens = text.split(",", ":")
        tokens.forEach {
            negativeCheck(it)
            if (it.toInt().toString() != it) throw IllegalArgumentException("$it not allowed")
            return resultSum(tokens)
        }
        return -1
    }

    private fun negativeCheck(number: String) {
        if (number.toInt() < 0) throw RuntimeException("$number is negative")
    }

    private fun checkInt(text: String) {
        if (text.toInt().toString() != text) throw IllegalArgumentException("숫자만 입력이 가능합니다.")
        negativeCheck(text)
    }

    private fun resultSum(inputnumbers: List<String>): Int {
        inputnumbers.forEach { inputnumber -> if (inputnumber.toInt() < 0) throw RuntimeException("$inputnumber is negative") }
        return inputnumbers.map { it.toInt() }.sum()
    }

    private fun regexSplit(text: String): Int {

        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return resultSum(tokens)
        }
        return -1
    }
}
