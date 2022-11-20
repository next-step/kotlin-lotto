package calculator

import calculator.application.Calculator
import calculator.application.impl.StandardCalculator
import calculator.domain.operation.AdditionBinaryOperation
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    lateinit var calculator: Calculator

    "숫자 여러개를 더할 수 있다" {
        val firstNumber = 1
        val secondNumber = 3
        val thirdNumber = 42

        calculator = StandardCalculator(AdditionBinaryOperation)

        val result = calculator.multiplePlus(firstNumber, secondNumber, thirdNumber)
        result shouldBe firstNumber + secondNumber + thirdNumber
    }
})
