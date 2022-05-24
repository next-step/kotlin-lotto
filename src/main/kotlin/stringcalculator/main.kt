package stringcalculator

import stringcalculator.dto.InputDto
import stringcalculator.service.CustomExpressionCalculator
import stringcalculator.view.CustomExpressionCalculatorView

fun main() {
    println(CustomExpressionCalculatorView.getInputViewString())
    val inputString = readln()
    val inputDto = InputDto(inputString)

    val customExpressionCalculator = CustomExpressionCalculator(inputDto)

    val outPutDto = customExpressionCalculator.getTotal()
    println(CustomExpressionCalculatorView.getOutputViewString(inputDto, outPutDto))
}
