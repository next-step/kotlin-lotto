package advancedcalculate.service

import advancedcalculate.domain.AdvancedCalculator

class AdvancedCalculatorService {
    fun calculate(input: String): Double {
        val advancedCalculator = AdvancedCalculator(input)
        return advancedCalculator.calculate()
    }
}
