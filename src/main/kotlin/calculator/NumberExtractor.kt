package calculator

import calculator.dto.PositiveNum
import calculator.dto.PositiveNums

object NumberExtractor {
    private val PARSER_RULE = Regex("//(.)\n(.*)")
    private val STD_DELIMITER = Regex("[,:]")

    fun extract(text: String): PositiveNums {
        val result = PARSER_RULE.find(text)
        val delimiter = result?.groupValues?.get(1)

        val tokens = when (delimiter) {
            null -> text.split(STD_DELIMITER)
            else -> result.groupValues[2].split(delimiter)
        }

        return tokens
            .map { PositiveNum(it) }
            .let { PositiveNums(it) }
    }
}
