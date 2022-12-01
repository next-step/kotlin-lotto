package step1.calculator.domain

import step1.calculator.extractor.CustomTermsExtractor
import step1.calculator.extractor.DefaultTermsExtractor
import step1.calculator.extractor.TermsExtractable

enum class DelimiterType(private val pattern: String) {
    COMMA(","),
    COLON(":"),
    MIXED("[,:]"),
    CUSTOM("""//(.)\n(.*)""");

    private fun contains(expression: String): Boolean =
        toRegex().containsMatchIn(expression)

    fun toRegex(): Regex = pattern.toRegex()

    fun find(expression: String): MatchResult =
        toRegex().find(expression)
            ?: throw IllegalArgumentException(NOT_MATCHED_PATTERN_ERROR_MESSAGE.format(expression, pattern))

    fun extractDelimiter(expression: String): String {
        if (isCustom()) {
            return extractCustomDelimiter(expression)
        }
        return pattern
    }

    fun getExtractor(): TermsExtractable {
        if (isCustom()) {
            return CustomTermsExtractor()
        }
        return DefaultTermsExtractor()
    }

    private fun isCustom(): Boolean = this == CUSTOM

    private fun extractCustomDelimiter(expression: String): String {
        val customDelimiterRegexPattern = CUSTOM.pattern.toRegex()
        val findMatchGroup: MatchResult = customDelimiterRegexPattern.find(expression) ?: throw IllegalArgumentException("")
        return findMatchGroup.groupValues[1]
    }

    companion object {
        private const val DELIMITER_NOT_FOUND_ERROR_MESSAGE = """입력된 문자열 [%s]에서 구분자를 찾을 수 없습니다. 기본 구분자는 콤마 혹은 콜론을, 사용자 정의 구분자는 '//'와 '\n'사이에 입력하세요"""
        private const val NOT_MATCHED_PATTERN_ERROR_MESSAGE = "입력된 문자열 [%s]와 패턴 [%s]이 일치하지 않습니다."

        fun match(expression: String): DelimiterType {
            if (containsMixed(expression)) {
                return MIXED
            }
            return findDelimiterType(expression)
        }

        private fun containsMixed(expression: String): Boolean = containsComma(expression) && containsColon(expression)

        private fun containsComma(expression: String): Boolean = COMMA.contains(expression)

        private fun containsColon(expression: String): Boolean = COLON.contains(expression)

        private fun findDelimiterType(expression: String): DelimiterType {
            val matches: MutableSet<DelimiterType> = mutableSetOf()

            values().map {
                if (it.contains(expression)) {
                    matches.add(it)
                }
            }

            return matches.firstOrNull() ?: throw IllegalArgumentException(DELIMITER_NOT_FOUND_ERROR_MESSAGE.format(expression))
        }
    }
}
