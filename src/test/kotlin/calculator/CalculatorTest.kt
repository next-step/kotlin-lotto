package calculator

import calculator.application.calculator.Calculator
import calculator.application.calculator.impl.StandardCalculator
import calculator.common.model.PositiveInteger
import calculator.domain.operation.AdditionBinaryOperation
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    lateinit var calculator: Calculator

    "숫자 여러개를 더할 수 있다" {
        val numberList = listOf(1, 3, 42).map { PositiveInteger(it) }

        calculator = StandardCalculator(AdditionBinaryOperation)

        val result = calculator.multiplePlus(numberList)
        result shouldBe numberList.sumOf { positiveInteger -> positiveInteger.value }
    }
})
