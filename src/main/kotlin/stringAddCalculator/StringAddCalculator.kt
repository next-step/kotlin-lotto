package stringAddCalculator

import java.util.LinkedList

object StringAddCalculator {
    private const val ZERO = 0
    private const val LENGTH_IS_ONE = 1
    private const val CUSTOM_SEPARATOR_PREFIX = "//"

    fun add(text: String?): Int {
        return when {
            text.isNullOrEmpty() -> ZERO
            text.length == LENGTH_IS_ONE -> oneNumberAdd(text)
            text.startsWith(CUSTOM_SEPARATOR_PREFIX) -> customAdd(text)
            else -> regularAdd(text)
        }
    }

    private fun oneNumberAdd(text: String): Int {
        return Token(tokens = LinkedList(listOf(text))).toInt()
    }

    private fun customAdd(text: String): Int {
        val tokens: List<String> = customTokenizer(text)
        return Token(tokens = tokens).sumOf()
    }

    private fun regularAdd(text: String): Int {
        val tokens = text.split(",|:".toRegex())
        return Token(tokens = tokens).sumOf()
    }

    private fun customTokenizer(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text) ?: throw RuntimeException()
        result.let {
            val (customDelimiter, groupValues) = it.destructured
            return it.groupValues[2].split(customDelimiter)
        }
    }
}
