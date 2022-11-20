package calculator

import calculator.domain.operation.AdditionBinaryOperation
import calculator.domain.operation.BinaryOperationCommand
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BinaryOperationBddTest : BehaviorSpec({

    given("2개의 숫자 값이 주어졌을 때") {
        val firstNumber = 1
        val secondNumber = 3

        `when`("이항식 더하기 연산을 하면") {
            val binaryOperation = AdditionBinaryOperation
            val binaryOperationCommand = BinaryOperationCommand(leftArgument = firstNumber, rightArgument = secondNumber)
            val result = binaryOperation.operate(binaryOperationCommand)

            then("연산이 된다") {
                result shouldBe firstNumber + secondNumber
            }
        }
    }
})
