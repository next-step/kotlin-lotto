package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class StringCalculatorTest : StringSpec({
    "문자열 덧셈 계산기는 유효하지 않은 문자열을 입력하는 경우 0을 반환한다." {
        val calculator = StringCalculator()
        forAll(
            row(""),
            row(null)
        ) { input ->
            calculator.add(input) shouldBe 0
        }
    }
    "문자열 덧셈 계산기는 단일 숫자 입력에 해당 숫자를 그대로 반환한다." {
        val calculator = StringCalculator()
        checkAll(Arb.int(10..100)) { input ->
            calculator.add(input.toString()) shouldBe input
        }
    }
})
