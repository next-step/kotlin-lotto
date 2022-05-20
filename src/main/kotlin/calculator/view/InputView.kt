package calculator.view

import calculator.processor.InputProcessor

object InputView {
    fun getInputStrAndConvertToList() {
        val inputStr = readlnOrNull()

        val inputProcessor = InputProcessor()
        inputProcessor.convertStringToList(inputStr)
    }
}
