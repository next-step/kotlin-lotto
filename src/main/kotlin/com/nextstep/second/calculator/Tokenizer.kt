package com.nextstep.second.calculator

val NORMAL_DELIMITERS = "[:,]".toRegex()
val CUSTOM_DELIMITERS_FINDER = "^//(.)\n(.*)".toRegex()
const val ERROR_MSG = "문자열 형식에 맞지 않습니다"

object Tokenizer {
    fun tokenize(text: String): List<String> {
        return if (CUSTOM_DELIMITERS_FINDER.matches(text)) {
            tokenizeByCustomDelimiter(text)
        } else {
            tokenizeByNormalDelimiter(text)
        }
    }

    private fun tokenizeByCustomDelimiter(text: String): List<String> {
        try {
            val parsedToken = CUSTOM_DELIMITERS_FINDER.find(text)
            return parsedToken?.let { it.groupValues[2].split(it.groupValues[1]) } ?: emptyList()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_MSG)
        }
    }

    private fun tokenizeByNormalDelimiter(text: String): List<String> {
        try {
            return text.split(NORMAL_DELIMITERS)
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_MSG)
        }
    }
}
