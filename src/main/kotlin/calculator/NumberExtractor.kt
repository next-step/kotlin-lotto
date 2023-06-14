package calculator

/**
 * 주어진 연산식에서 숫자 문자열을 추출하는 역할을 하는 클래스입니다.
 */
class NumberExtractor {
    companion object {
        private val pattern = """(?:\/\/(.)\n)*(.*)""".toRegex()
    }

    fun extract(text: String?): List<String> {
        if (text.isNullOrBlank()) {
            return listOf()
        }
        val result = pattern.find(text)
        return result?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val tokens = matchResult.groupValues[2].split("[,:$customDelimiter]".toRegex())
            require(tokens.all { it.toInt() >= 0 }) { "input number must be positive" }
            tokens
        } ?: listOf()
    }
}
