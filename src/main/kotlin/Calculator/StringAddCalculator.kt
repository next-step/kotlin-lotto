package Calculator

import java.util.regex.Matcher
import java.util.regex.Pattern

class StringAddCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val tokens = splitTokens(input)
        tokens.firstOrNull { it > 0 } ?: throw RuntimeException("0 이상의 숫자를 입력해주세요.")

        return tokens.sum()
    }

    private fun splitTokens(input: String): List<Int> {
        val matcher: Matcher = Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(input)
        val custom = matcher.find()
        val splitList = if (custom) {
            matcher.group(2).split(matcher.group(1))
        } else {
            input.split(",", ":")
        }
        return splitList.map { it.toInt() }
    }

    companion object {
        private const val CUSTOM_SPLIT_PATTERN = "^//(.)\n(.*)"
    }
}