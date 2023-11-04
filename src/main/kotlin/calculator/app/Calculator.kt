package calculator.app

import calculator.model.Tokenizer

object Calculator {

    fun calculate(input: String): Int {
        val formula = Tokenizer.tokenize(input)
        if (formula.tokens.isEmpty()) {
            return 0
        }
        return formula.sum().value
    }
}
