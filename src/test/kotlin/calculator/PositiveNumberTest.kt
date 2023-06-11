package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class PositiveNumberTest : FunSpec({

    context("init") {
        test("음수가 입력되는 경우 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> { PositiveNumber(value = -1) }
            exception.message shouldBe "음수는 입력될 수 없다"
        }
    }
})
