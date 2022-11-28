package calculator

class StringAddCalculator {

    private val splitterFactory = SplitterFactory()
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return DEFAULT_RESULT_VALUE
        }
        val splitter = splitterFactory.getSplitter(text)
        return sum(splitter.split(text))
    }

    private fun sum(tokens: List<String>): Int = tokens.sumOf { toInt(it) }
    private fun toInt(text: String): Int {
        val result = text.toIntOrNull() ?: throw throw RuntimeException("입력값은 숫자만 가능합니다.")
        validatePlus(result)
        return result
    }

    private fun validatePlus(input: Int) {
        if (input < 0) {
            throw RuntimeException("입력값은 음수가 올수 없습니다.")
        }
    }

    companion object {
        private const val DEFAULT_RESULT_VALUE = 0
    }
}
