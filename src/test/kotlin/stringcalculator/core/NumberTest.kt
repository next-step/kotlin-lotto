package stringcalculator.core

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class NumberTest {
    @Test
    fun `음수를 지정하면 Runtime Exception이 발생함을 확인한다`() {
        shouldThrow<RuntimeException> {
            Number("-1")
        }
    }

    @Test
    fun `숫자가 아닌 값을 지정하면 Runtime Exception이 발생함을 확인한다`() {
        shouldThrow<RuntimeException> {
            Number("ㅁㅇ")
        }
    }
}
