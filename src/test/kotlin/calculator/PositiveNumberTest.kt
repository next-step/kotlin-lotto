package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PositiveNumberTest {

    @Test
    fun `숫자가 아닌 문자는 예외가 발생한다`() {
        shouldThrow<RuntimeException> {
            PositiveNumber.of("a")
        }.apply {
            message shouldBe "숫자를 입력하세요"
        }
    }

    @Test
    fun `음수를 입력하면 예외가 발생한다`() {
        shouldThrow<RuntimeException> {
            PositiveNumber.of("-1")
        }.apply {
            message shouldBe "0보다 큰 양수를 입력하세요"
        }
    }


}