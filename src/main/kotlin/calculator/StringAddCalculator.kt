package calculator

object StringAddCalculator {

    private val customDelimiterRule: Regex = Regex("//(.)\n(.*)")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers: List<Int> = getNumbersFrom(text)
        checkNegative(numbers)

        return numbers.sum()
    }

    private fun getNumbersFrom(text: String): List<Int> =
        (getTokenWithCustomDelimiter(text) ?: getToken(text)).map { it.toInt() }

    private fun getTokenWithCustomDelimiter(text: String): List<String>? =
        customDelimiterRule.find(text)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }

    private fun getToken(text: String): List<String> =
        text.split(',', ':')

    private fun checkNegative(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수를 입력할 수 없습니다.")
        }
    }
}
