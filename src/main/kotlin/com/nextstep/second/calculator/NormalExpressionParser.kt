package com.nextstep.second.calculator

class NormalExpressionParser(text: String?) : ExpressionParser(text) {

    override fun parse(text: String): List<Int> {
        try {
            val tokens = text.split(DELIMITERS.toRegex())
            return tokens.map { it.toInt() }
        } catch(e: Exception) {
            throw IllegalArgumentException("문자열 형식에 맞지 않습니다")
        }
    }

    companion object {
        const val DELIMITERS = "[:,]"
    }
}