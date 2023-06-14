package com.nextstep.second.calculator

const val NORMAL_DELIMITERS = "[:,]"
val normalTokenize: (String) -> List<String> = { text: String ->
    try {
        text.split(NORMAL_DELIMITERS.toRegex())
    } catch(e: Exception) {
        throw IllegalArgumentException("문자열 형식에 맞지 않습니다")
    }
}

const val CUSTOM_DELIMIETERS_FINDER = "//(.)\n(.*)"
val customTokenize: (String) -> List<String> = { text: String ->
    try {
        val parsedToken = Regex(CUSTOM_DELIMIETERS_FINDER).find(text)
        var result: List<String> = emptyList()
        parsedToken?.let {
            val customDelimiter = it.groupValues[1]
            result = it.groupValues[2].split(customDelimiter)
        }
        result
    } catch(e: Exception) {
        throw IllegalArgumentException("문자열 형식에 맞지 않습니다")
    }
}