package calculator.domain

import calculator.vo.Tokens

object Calculator {
    fun run(tokens: Tokens): Int {
        return tokens.sum()
    }
}
