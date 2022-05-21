package stringcalculator.service

import stringcalculator.domain.Calculator
import stringcalculator.domain.customparser.CustomExpressionParser
import stringcalculator.dto.InputDto
import stringcalculator.dto.OutPutDto

class CustomExpressionCalculator(inputDto: InputDto) {
    private val customExpressionParser: CustomExpressionParser = CustomExpressionParser(inputDto.inputString)

    fun getTotal(): OutPutDto {
        return OutPutDto(Calculator.getTotalSum(customExpressionParser.getParsedNumber()))
    }
}
