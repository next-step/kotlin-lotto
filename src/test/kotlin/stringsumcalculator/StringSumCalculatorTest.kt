package stringsumcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringSumCalculatorTest : StringSpec({
    "1,2:3을 입력하면 6을 반환한다" {
        val sum = StringSumCalculator.sum("//;\n1,2:3")

        val actual = sum.toInt()

        actual shouldBe 6
    }

    "null, 빈 문자열을 입력하면 0을 반환한다" {
        forAll(
            row(null, 0),
            row("", 0),
            row(" ", 0),
        ) { a, b ->
            val sum = StringSumCalculator.sum(a)

            val actual = sum.toInt()

            actual shouldBe b
        }
    }
})
