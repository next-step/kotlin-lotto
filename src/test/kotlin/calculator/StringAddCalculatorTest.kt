package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : FunSpec({

    lateinit var calculator: StringAddCalculator

    beforeTest {
        calculator = StringAddCalculator()
    }

    context("StringAddCalculator") {
        test("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.") {
            listOf(null, "").forEach { text ->
                calculator.add(text) shouldBe 0
            }
        }

        test("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
            calculator.add("1,2:3") shouldBe 6
        }

        test("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.") {
            calculator.add("//;\n1;2;3") shouldBe 6
        }
    }
})
