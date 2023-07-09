package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PositiveNumberTest {

    @Test
    fun `문자를 받아 객체를 생성한다`() {
        val positiveNumber = PositiveNumber.fromString("1")

        positiveNumber.value shouldBe 1
    }

    @Test
    fun `음수를 받으면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { PositiveNumber(-1) }
    }
}
