package calculator

import caculator.StringCalculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val calculator = StringCalculator()

    "문자열은 빈자열 또는 null일 경우 0을 반환한다." {
        calculator.add(null) shouldBe 0
        calculator.add("") shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        calculator.add("1") shouldBe 1
    }
})
