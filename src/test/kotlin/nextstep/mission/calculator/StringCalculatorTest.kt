package nextstep.mission.calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "빈 문자열을 입력하면 0을 반환한다." {
        StringCalculator().calculate("") shouldBe 0
    }

    "음수를 입력하면 RuntimeException 예외를 던진다." {
        shouldThrowExactly<RuntimeException> {
            StringCalculator().calculate("-1")
        }
    }
})
