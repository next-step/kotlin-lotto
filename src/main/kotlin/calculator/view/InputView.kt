package calculator.view

import calculator.model.PositiveNumber
import calculator.processor.InputProcessor

class InputView {
    fun getInputStrAndConvertToList(): List<PositiveNumber> {
        val inputStr = readlnOrNull()

        val inputProcessor = InputProcessor()
        return inputProcessor.convertStringToList(inputStr)
    }
}
