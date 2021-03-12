package calculator.domain

import calculator.vo.DEFAULT_TOKEN_VALUE
import calculator.vo.Token
import calculator.vo.Tokens

const val DEFAULT_DELIMITER_1 = ','
const val DEFAULT_DELIMITER_2 = ':'

object Translator {
    fun run(input: String?): Tokens {
        if (input.isNullOrBlank()) {
            return Tokens(listOf(Token()))
        }
        val result = translateToList(input)
        val tokens = translateToToken(result)
        return Tokens(tokens)
    }

    private fun translateToList(input: String): List<String> {
        var result = translateWithCustom(input)

        if (result.isEmpty()) {
            result = translateWithDefault(input)
        }
        return result
    }

    private fun translateToToken(result: List<String>): List<Token> {
        return result.asSequence().map {
            if (it.isBlank()) DEFAULT_TOKEN_VALUE
            it.toToken()
        }.toList()
    }

    private fun translateWithDefault(input: String) = input.split(DEFAULT_DELIMITER_1, DEFAULT_DELIMITER_2)

    private fun translateWithCustom(input: String): List<String> {
        val regexForCustomDelim = Regex("//(.)\n(.*)").find(input)

        regexForCustomDelim?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }

        return emptyList()
    }
}

fun String.toToken(): Token {
    return Token(Checker.parseInteger(this))
}
