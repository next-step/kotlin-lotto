package stringsumcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SumTest : StringSpec({
    "숫자들의 합이 올바르게 계산된다" {
        val sum = Sum(StringNumbers("1,2,3,4"))

        val actual = sum.toInt()

        actual shouldBe 10
    }
})
