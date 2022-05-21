package stringcalculator.service

import stringcalculator.domain.Calculator
import stringcalculator.domain.StringExpressionParser
import stringcalculator.dto.InputDto
import stringcalculator.dto.OutPutDto

class CustomExpressionCalculator(inputDto: InputDto) {
    private val stringExpressionParser: StringExpressionParser = StringExpressionParser(inputDto.inputString)

    fun getTotal(): OutPutDto {
        return OutPutDto(Calculator.getTotalSum(stringExpressionParser.getParsedNumber()))
    }
}
