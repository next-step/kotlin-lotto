package advancedcalculate

import advancedcalculate.controller.AdvancedCalculatorController
import advancedcalculate.service.AdvancedCalculatorService

fun main() {

    val input = readLine()!!
    
    val advancedCalculatorController = AdvancedCalculatorController(AdvancedCalculatorService())
    println(advancedCalculatorController.run(input))
}
