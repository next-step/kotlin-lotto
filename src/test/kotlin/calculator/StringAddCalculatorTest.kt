package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({


    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다." {
        forAll(
            row(""),
            row("  "),
            row(null)
        ) { text ->
            StringAddCalculator.add(text) shouldBe 0
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        forAll(
            row("1", 1),
            row("100", 100)
        ) { text, expected ->
            StringAddCalculator.add(text) shouldBe expected
        }
    }
})
