package advancedcalculate

import advancedcalculate.controller.AdvancedCalculatorController
import advancedcalculate.service.AdvancedCalculatorService

fun main() {

    val advancedCalculatorController = AdvancedCalculatorController(AdvancedCalculatorService())

    val input = readln()
    println(advancedCalculatorController.run(input))
}
