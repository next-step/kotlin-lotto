package calculator

import calculator.application.calculator.impl.StandardCalculator
import calculator.application.parser.impl.DelimiterParser
import calculator.common.model.PositiveIntegers
import calculator.domain.operation.AdditionBinaryOperation
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class SystemBddTest : BehaviorSpec({

    val parser = DelimiterParser
    val calculator = StandardCalculator(additionOperation = AdditionBinaryOperation)

    given("\"//;\\n1;2;3\"이 입력되었을 때") {

        val inputString = "//;\n1;2;3"
        val numberList = PositiveIntegers(parser.parseToPositiveIntegerList(inputString))

        `when`("계산기가 연산을 하면") {

            val result = calculator.multiplePlus(numberList)

            then("결과 값은 6이 반환되어야 한다.") {
                result shouldBe 6
            }
        }
    }
})
