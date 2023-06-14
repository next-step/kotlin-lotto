package com.nextstep.second.calculator

class CustomExpressionParser(text: String?) : ExpressionParser(text) {

    override fun parse(text: String): List<Int> {
        try {
            val parsedToken = Regex("//(.)\n(.*)").find(text)
            val numList = mutableListOf<Int>()
            parsedToken?.let {
                val customDelimiter = it.groupValues[1]
                val tokens = it.groupValues[2].split(customDelimiter)
                tokens.map { numList.add(it.toInt()) }
            }
            return numList
        } catch(e: Exception) {
            throw IllegalArgumentException("문자열 형식에 맞지 않습니다")
        }
    }
}