package stringcalculator

import stringcalculator.model.StringCalculator
import stringcalculator.model.StringConverter
import stringcalculator.view.InputView
import stringcalculator.view.ResultView

fun main() {
    StringCalculatorController().execute()
}

class StringCalculatorController(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView,
    private val stringConverter: StringConverter = StringConverter,
    private val stringCalculator: StringCalculator = StringCalculator
) {

    fun execute() {
        val result = try {
            val sum = stringCalculator.sumString(stringConverter.splitInput(inputView.getInput()))
            sum.toString()
        } catch (e: Exception) {
            e.localizedMessage
        }
        showResult(result)
    }

    private fun showResult(result: String) {
        resultView.showResult(result)
    }
}
