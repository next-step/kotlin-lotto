package domain.calculator.ui

import domain.calculator.ui.ViewConstants.INPUT_EXPRESSION_MESSAGE
import global.strategy.InputStrategy
import global.strategy.OutputStrategy

class InputView(private val outputStrategy: OutputStrategy, private val inputStrategy: InputStrategy) {
    fun inputExpression(): String? {
        outputStrategy.output(INPUT_EXPRESSION_MESSAGE)
        return inputStrategy.input()
    }
}
