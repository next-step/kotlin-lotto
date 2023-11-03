package calculator.app

import calculator.model.Formula
import calculator.model.Token
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 해야 한다" {
        val formula = Formula(listOf(3))
        val actual = StringCalculator.calculate(formula)
        actual shouldBe 3
    }

    "숫자 두개를 입력할 경우 두 숫자의 합을 반환 해야 한다 " {
        val formula = Formula(listOf(1, 2))
        val actual = StringCalculator.calculate(formula)
        actual shouldBe 3
    }

    "비어있는 컬렉션을 받은 경우 0 을 반환해야한다" {
        val actual = StringCalculator.calculate(
            Formula(ArrayDeque<Token>())
        )
        actual shouldBe 0
    }
})
