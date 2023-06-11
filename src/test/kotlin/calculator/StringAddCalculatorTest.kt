package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({

    "커스텀 구분자와 기본 구분자를 사용하여 계산하면 정상적으로 값을 반환한다." {
        forAll(
            row("1:2,3:4", "10"),
            row("5,6,7,8,9,1,1", "37"),
            row("${Int.MAX_VALUE},${Int.MAX_VALUE},${Int.MAX_VALUE}", "${Int.MIN_VALUE}"),
            row("//^\n0^1^2^7", "10"),
            row("//?\n0?1?2?7", "10"),
            row("//+\n0+1+2+7", "10"),
            row("//+\n0++1+2+7", "10"),
        ) { text, expect ->
            val actual = StringAddCalculator.calculate(
                stringCalculatorText = text
            )

            actual.result shouldBe expect.toIntOrNull()
        }
    }
})
