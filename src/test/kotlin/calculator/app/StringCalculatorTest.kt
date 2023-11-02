package calculator.app

import calculator.component.Helper
import calculator.fixture.TokenFixture
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 해야 한다" {
        val actual = StringCalculator.calculate(Helper.arrayDequeOf(TokenFixture.TOKEN[3]))
        actual shouldBe 3
    }

    "숫자 두개를 입력할 경우 두 숫자의 합을 반환 해야 한다 " {
        val actual = StringCalculator.calculate(Helper.arrayDequeOf(TokenFixture.TOKEN[1], TokenFixture.TOKEN[2]))
        actual shouldBe 3
    }

    "비어있는 컬렉션을 받은 경우 0 을 반환해야한다" {
        val actual = StringCalculator.calculate(ArrayDeque())
        actual shouldBe 0
    }
})
