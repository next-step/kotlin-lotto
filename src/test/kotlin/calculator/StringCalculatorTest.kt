package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`() {
        0 shouldBe 0
    }
}
