package calculator

import calculator.application.Calculator
import calculator.application.impl.StandardCalculator
import calculator.domain.operation.AdditionBinaryOperation
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    lateinit var calculator: Calculator

    "숫자 2개를 더하기 연산할 수 있다" {
        val firstNumber = 1
        val secondNumber = 3

        calculator = StandardCalculator(AdditionBinaryOperation)

        val result = calculator.plus(firstNumber, secondNumber)
        result shouldBe firstNumber + secondNumber
    }
})
