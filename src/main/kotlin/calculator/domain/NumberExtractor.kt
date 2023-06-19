package calculator.domain

/**
 * 주어진 연산식에서 숫자 문자열을 추출하는 역할을 하는 클래스입니다.
 */
class NumberExtractor {
    fun extract(text: String?): List<Int> {
        if (text.isNullOrBlank()) {
            return listOf()
        }
        val result = pattern.find(text)
        return result?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            val tokens = matchResult.groupValues[2].split("[,:$customDelimiter]".toRegex())
            tokens.map {
                val maybeNumber = it.toIntOrNull()
                require(maybeNumber != null) { "invalid input detected" }
                require(maybeNumber >= 0) { "input number must be positive" }
                maybeNumber
            }
        } ?: listOf()
    }

    companion object {
        private val pattern = """(?:\/\/(.)\n)*(.*)""".toRegex()
    }
}
