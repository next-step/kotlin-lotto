package calculator.app

import calculator.component.Helper
import calculator.fixture.TokenFixture
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 해야 한다" {
        val cal = StringCalculator()
        val calculate = cal.calculate(Helper.arrayDequeOf(TokenFixture.tokenThree))
        calculate shouldBe 3
    }

    "숫자 두개를 입력할 경우 두 숫자의 합을 반환 해야 한다 " {
        val cal = StringCalculator()
        val calculate = cal.calculate(Helper.arrayDequeOf(TokenFixture.tokenOne, TokenFixture.tokenTwo))
        calculate shouldBe 3
    }
})
