package advancedcalculate.controller

import advancedcalculate.service.AdvancedCalculatorService

class AdvancedCalculatorController(private val advancedCalculatorService: AdvancedCalculatorService) {

    fun run(input: String): Double {
        return advancedCalculatorService.calculate(input)
    }
}
