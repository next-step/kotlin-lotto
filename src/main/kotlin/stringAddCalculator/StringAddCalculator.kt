package stringAddCalculator

import java.util.LinkedList

class StringAddCalculator {

    fun add(text: String?): Int {
        return when {
            text.isNullOrEmpty() -> 0
            text.length == 1 -> oneNumberAdd(text)
            text.startsWith("//") -> customAdd(text)
            else -> regularAdd(text)
        }
    }

    private fun oneNumberAdd(text: String): Int {
        validateTokens(LinkedList(listOf(text)))
        return text.toInt()
    }

    private fun customAdd(text: String): Int {
        val tokens: List<String> = customTokenizer(text)
        validateTokens(tokens)
        return tokens.sumOf { it.toInt() }
    }

    private fun regularAdd(text: String): Int {
        val tokens = text.split(",|:".toRegex())
        validateTokens(tokens)
        return tokens.sumOf { it.toInt() }
    }

    private fun customTokenizer(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        result!!.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
    }

    private fun validateTokens(tokens: List<String>) {
        tokens.forEach {
            if (it.toInt() < 0) {
                throw RuntimeException()
            }
        }
    }
}
