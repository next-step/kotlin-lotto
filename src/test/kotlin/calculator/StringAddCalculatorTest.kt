package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : FreeSpec({

    "checkInput" - {

        "null일 경우 0을 반환한다." {
            val calculator = StringAddCalculator()
            val input = null

            calculator.checkInput(input) shouldBe "0"
        }

        "빈값일 경우 0을 반환한다." {
            val calculator = StringAddCalculator()
            val input = ""

            calculator.checkInput(input) shouldBe "0"
        }
    }

    "splitString" - {

        "한개의 문자열일 경우도 리스트로 반환된다." {
            val calulator = StringAddCalculator()
            val input = "1"

            calulator.splitString(input) shouldBe listOf("1")
        }

        "콤마(,) 구분자 기준으로 문자열이 분리된다." {
            val calculator = StringAddCalculator()
            val input = "1,2"

            calculator.splitString(input) shouldBe listOf("1", "2")
        }

        "콜론(:) 구분자 기준으로 문자열이 분리된다." {
            val calculator = StringAddCalculator()
            val input = "1:2"

            calculator.splitString(input) shouldBe listOf("1", "2")
        }

        "콤마, 콜론 두개를 기준으로 문자열이 분리된다." {
            val calculator = StringAddCalculator()
            val input = "1,2:3"

            calculator.splitString(input) shouldBe listOf("1", "2", "3")
        }

        "//와 \n 문자 사이에 커스텀 구분자를 기준으로 문자열이 분리된다." {
            val calculator = StringAddCalculator()
            val input = "//;\n1;2;3"

            calculator.splitString(input) shouldBe listOf("1", "2", "3")
        }
    }

    "add" - {

        "숫자 리스트의 모든 수의 합을 반환한다." {
            val calculator = StringAddCalculator()
            val inputList = listOf(1, 2, 3)

            calculator.add(inputList) shouldBe 6
        }
    }

    "convertInt" - {

        "음수가 있으면 에러를 반환한다." {
            val calculator = StringAddCalculator()
            val inputList = listOf<String>("1", "-1", "2")

            shouldThrow<RuntimeException> {
                calculator.convertInt(inputList)
            }
        }
    }
})
