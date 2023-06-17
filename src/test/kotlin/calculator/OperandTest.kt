package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class OperandTest : StringSpec({
    "피연산자 생성 시 음수가 주어질 경우 에러가 발생 한다." {
        shouldThrow<RuntimeException> { PositiveOperand("-1") }
    }

    "피연산자 생성 시 숫자가 아닌 값이 주어질 경우 에러가 발생 한다." {
        shouldThrow<RuntimeException> { PositiveOperand("$") }
    }
})
