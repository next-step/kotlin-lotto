package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다" {
        val add = StringCalculator.add(null)
        add shouldBe 0
    }
})
