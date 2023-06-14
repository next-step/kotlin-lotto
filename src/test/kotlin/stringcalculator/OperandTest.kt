package stringcalculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperandTest : StringSpec({
    "빈 문자열을 입력할 경우 0을 반환해야 한다." {
        Operand.of("") shouldBe Operand(0)
    }

    "음수를 전달할 경우 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Operand(-1)
        }
    }

    "0 또는 양수를 전달할 경우 예외가 발생하지 않는다." {
        shouldNotThrowAny {
            Operand(0)
            Operand(1)
        }
    }
})
