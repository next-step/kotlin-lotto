package com.nextstep.second.calculator

const val NORMAL_DELIMITERS = "[:,]"
const val CUSTOM_DELIMITERS_FINDER = "^//(.)\n(.*)"
const val ERROR_MSG = "문자열 형식에 맞지 않습니다"

object Tokenizer {
    fun tokenize(text: String): List<String> {
        return if (Regex(CUSTOM_DELIMITERS_FINDER).matches(text)) {
            tokenizeByCustomDelimiter(text)
        } else {
            tokenizeByNormalDelimiter(text)
        }
    }

    fun tokenizeByNormalDelimiter(text: String): List<String> {
        try {
            return parseTextWithRegex(text, NORMAL_DELIMITERS.toRegex())
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_MSG)
        }
    }

    fun tokenizeByCustomDelimiter(text: String): List<String> {
        try {
            val parsedToken = Regex(CUSTOM_DELIMITERS_FINDER).find(text)
            return parsedToken?.let { parseTextWithRegex(it.groupValues[2], it.groupValues[1]) } ?: emptyList()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_MSG)
        }
    }

    private fun parseTextWithRegex(text: String, regexString: String): List<String> {
        return text.split(regexString)
    }

    private fun parseTextWithRegex(text: String, regex: Regex): List<String> {
        return text.split(regex)
    }
}
