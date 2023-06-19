package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "숫자를 전달하면 합이 계산된다" {
        StringCalculator.add("1,2,3") shouldBe 6
    }
})
