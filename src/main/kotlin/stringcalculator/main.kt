package stringcalculator

import stringcalculator.dto.InputDto
import stringcalculator.service.CustomExpressionCalculator
import stringcalculator.view.CustomExpressionCalculatorView

fun main() {
    val customExpressionCalculatorView = CustomExpressionCalculatorView()
    println(customExpressionCalculatorView.getInputViewString())
    val inputString = readln()
    val inputDto = InputDto(inputString)

    val customExpressionCalculator = CustomExpressionCalculator(inputDto)

    val outPutDto = customExpressionCalculator.getTotal()
    println(customExpressionCalculatorView.getOutputViewString(inputDto, outPutDto))
}
