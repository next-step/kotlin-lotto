package stringcalculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "콤마(,) 혹은 콜론(:)을 포함한 문자열 내에 있는 숫자들의 합계를 반환한다." {
        val commaExp = "1,2,3"
        val colonExp = "1:2:3"
        val calculator = StringCalculator()

        val result1 = calculator.sum(commaExp)
        val result2 = calculator.sum(colonExp)

        assertSoftly {
            result1 shouldBe 6
            result2 shouldBe 6
        }
    }

    "커스텀 구분자를 포함한 문자열 내에 있는 숫자들의 합계를 반환한다." {
        val exp = "//<\n1<2<3"
        val calculator = StringCalculator()

        val result = calculator.sum(exp)

        result shouldBe 6
    }

    "숫자 이외의 값이 전달될 경우 RuntimeException을 반환한다." {
        val exp = "m1:2:3"
        val calculator = StringCalculator()

        shouldThrow<RuntimeException> {
            calculator.sum(exp)
        }
    }

    "음수가 전달될 경우 RuntimeException을 반환한다." {
        val exp = "-1:2:3"
        val calculator = StringCalculator()

        shouldThrow<RuntimeException> {
            calculator.sum(exp)
        }
    }

    "값이 형식이 올바르지 않으면 RuntimeException을 반환한다." {
        val exp = "1?2>3"
        val calculator = StringCalculator()

        shouldThrow<RuntimeException> {
            calculator.sum(exp)
        }
    }
})
