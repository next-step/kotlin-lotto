package calculator

class TextParser {
    companion object {
        private const val DEFAULT_DELIMITERS = "[,:]" // [] 내부의 ,: 중 하나랑 매칭
        private const val CUSTOM_DELIMITER_PATTERN = """//(.+?)\n(.*)""" // () 안이 각각 그룹

        fun parse(text: String?): List<Int> {
            if (text.isNullOrBlank()) {
                return emptyList()
            }

            val (customDelimiter, numbers) = extractDelimiterAndNumbers(text)
            val combinedDelimiter = buildCombinedDelimiter(customDelimiter)
            return numbers.split(combinedDelimiter.toRegex()).map(String::toInt)
        }

        private fun extractDelimiterAndNumbers(text: String): Pair<String?, String> {
            val matchResult = Regex(CUSTOM_DELIMITER_PATTERN).find(text)
            return if (matchResult != null) {
                val (customDelimiter, numbers) = matchResult.destructured
                Pair(customDelimiter, numbers)
            } else {
                Pair(null, text)
            }
        }

        private fun buildCombinedDelimiter(customDelimiter: String?): String {
            return if (customDelimiter != null) {
                "($DEFAULT_DELIMITERS|${Regex.escape(customDelimiter)})" // ([,:]|;) 과 같이 매칭
            } else {
                DEFAULT_DELIMITERS
            }
        }
    }
}
