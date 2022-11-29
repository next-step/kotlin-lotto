package calculator

import calculator.`in`.CalculatorController
import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

fun main() {
    val consoleInput = ConsoleInput()
    val consoleOutPut = ConsoleOutput()
    val calculatorController = CalculatorController(consoleInput, consoleOutPut)

    calculatorController.start()
}
