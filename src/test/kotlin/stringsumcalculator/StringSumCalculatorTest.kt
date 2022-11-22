package stringsumcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringSumCalculatorTest : StringSpec({
    "1,2:3을 입력하면 6을 반환한다" {
        StringSumCalculator.sum("//;\n1,2:3").toInt() shouldBe 6
    }

    "null, 빈 문자열을 입력하면 0을 반환한다" {
        listOf(null, "", " ").forAll {
            StringSumCalculator.sum(it).toInt() shouldBe 0
        }
    }
})
