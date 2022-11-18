package calcuator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeGreaterThan

internal class OperandTest : StringSpec({
    "피연산사는 음수일 경우 RuntimeException 이 발생한다." {
        shouldThrow<RuntimeException> {
            Operand(-1)
        }
    }

    "피연산자는 양수이다." {
        forAll(
            row(1),
            row(2),
        ) { positiveNumber ->
            Operand(positiveNumber).number.shouldBeGreaterThan(-1)
        }
    }
})
