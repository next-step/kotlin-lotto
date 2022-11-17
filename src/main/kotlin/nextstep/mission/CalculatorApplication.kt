package nextstep.mission

import nextstep.mission.calculator.InputParser
import nextstep.mission.calculator.StringCalculator
import nextstep.mission.calculator.io.ConsoleInput
import nextstep.mission.calculator.io.ConsoleOutput

fun main() {
    val input: String? = ConsoleInput.input()
    val expression: List<Int> = InputParser.parse(input)
    val result: Int = StringCalculator.calculate(expression = expression.toMutableList())
    ConsoleOutput.output(result)
}
