package calculator

import calculator.model.evaluator.ExpressionEvaluator
import calculator.model.input.InputParser
import calculator.model.operator.AddOperator

class StringAddCalculator(private val operator: AddOperator = AddOperator()) {
    fun add(text: String?): Int {
        val numbers = InputParser.parse(text)
        val expressionEvaluator = ExpressionEvaluator(numbers, operator)
        return expressionEvaluator.evaluate()
    }
}
