package nextstep.mission.calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "빈 문자열 또는 null을 입력하면 0을 반환한다." {
        listOf(null, "").forAll {
            StringCalculator().calculate(it) shouldBe 0
        }
    }

    "음수를 입력하면 RuntimeException 예외를 던진다." {
        shouldThrowExactly<RuntimeException> {
            StringCalculator().calculate("-1")
        }
    }
})
