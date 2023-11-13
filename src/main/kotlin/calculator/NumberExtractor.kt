package calculator

import calculator.vo.PositiveNum
import calculator.vo.PositiveNums

object NumberExtractor {
    private val PARSER_RULE = Regex("//(.)\n(.*)")
    private val STD_DELIMITER = Regex("[,:]")

    fun extract(text: String): PositiveNums {
        val result = PARSER_RULE.find(text)

        val tokens = if (result != null) {
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(customDelimiter)
        } else {
            text.split(STD_DELIMITER)
        }

        val numberTokens = try {
            tokens.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 extract 가능합니다.")
        }

        return numberTokens
            .map { PositiveNum(it) }
            .let { PositiveNums(it) }
    }
}
