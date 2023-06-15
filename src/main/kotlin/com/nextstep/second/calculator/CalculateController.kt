package com.nextstep.second.calculator

object CalculateController {
    fun add(text: String): Int {
        val parsedNumberAsString = ExpressionParser.parse(text) { str ->
            Tokenizer.tokenize(str)
        }
        return StringAdderCalculator.execute(parsedNumberAsString)
    }
}
