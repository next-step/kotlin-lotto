package calculator

import calculator.dto.PositiveNum
import calculator.dto.PositiveNums

// TODO-review : 상태를 갖지 않은 객체이기에 object 로 Parser 를 선언했습니다.
object Parser {

    fun parse(text: String): PositiveNums {
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
