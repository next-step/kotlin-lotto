package calculator

import calculator.view.InputView

fun main() {
    val input = InputView.input()
    val formula = Formula(input)
    println(formula.calculate())
}
