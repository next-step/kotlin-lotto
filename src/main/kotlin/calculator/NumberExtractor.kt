package calculator

import calculator.dto.PositiveNum
import calculator.dto.PositiveNums

object NumberExtractor {

    fun extract(text: String): PositiveNums {
        val result = StringAddCalculator.PARSER_RULE.find(text)
        val delimiter = result?.groupValues?.get(1)

        val tokens = when (delimiter) {
            null -> text.split(StringAddCalculator.STD_DELIMITER)
            else -> result.groupValues[2].split(delimiter)
        }

        return tokens
            .map { PositiveNum(it) }
            .let { PositiveNums(it) }
    }
}
