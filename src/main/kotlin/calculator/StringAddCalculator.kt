package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        if (text.length == 1) return checkInt(text)
        return sum(splitText(text))
    }

    private fun splitText(text: String): List<String> {
        val tokens = text.split(",", ":")
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            tokens
        } ?: tokens
    }

    private fun sum(input: List<String>): Int {
        input.forEach { checkInt(it) }
        return input.sumOf { it.toInt() }
    }

    private fun checkInt(text: String): Int =
        if (text.toInt().toString() != text) throw IllegalArgumentException("숫자만 입력 가능합니다.")
        else if (text.toInt() < 0) throw RuntimeException("음수는 입력할 수 없습니다.")
        else text.toInt()
}
