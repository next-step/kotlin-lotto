package calculator.app

import calculator.model.Token

object StringCalculator {
    fun calculate(tokens: ArrayDeque<Token>): Int {
        if (tokens.isEmpty()) {
            return 0
        }
        val reduce = tokens
            .reduce { i, t -> i.add(t) }
        return reduce.value
    }
}
