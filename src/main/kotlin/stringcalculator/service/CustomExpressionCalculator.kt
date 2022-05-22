package stringcalculator.service

import stringcalculator.domain.Calculator
import stringcalculator.domain.customparser.CustomExpressionParser
import stringcalculator.domain.customparser.ParserSeparator
import stringcalculator.domain.customparser.ParserSeparators
import stringcalculator.dto.InputDto
import stringcalculator.dto.OutPutDto

class CustomExpressionCalculator(inputDto: InputDto) {
    private val customExpressionParser: CustomExpressionParser =
        CustomExpressionParser(inputDto.inputString, DEFAULT_SEPARATORS)

    fun getTotal(): OutPutDto {
        return OutPutDto(Calculator.getTotal(customExpressionParser.parsedNumber))
    }

    companion object {
        private val DEFAULT_SEPARATORS = ParserSeparators(
            mutableListOf(
                ParserSeparator(":"), ParserSeparator(",")
            )
        )
    }
}
