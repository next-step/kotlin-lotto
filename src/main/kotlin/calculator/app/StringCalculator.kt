package calculator.app

import calculator.model.Formula

object StringCalculator {
    fun calculate(formula: Formula): Int {
        if (formula.tokens.isEmpty()) {
            return 0
        }
        val reduce = formula.tokens
            .reduce { i, t -> i.add(t) }
        return reduce.value
    }
}
