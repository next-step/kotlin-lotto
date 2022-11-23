package stringsumcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SumTest : StringSpec({
    "숫자들의 합이 올바르게 계산된다" {
        Sum(StringSplitNumbers("1,2,3,4")).toInt() shouldBe 10
    }
})
