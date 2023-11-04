package calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class StringCalculator {

}

class StringCalculatorTest {
    @Test
    fun `문자열 계산기를 생성할 수 있다`() {
        assertDoesNotThrow { StringCalculator() }
    }
}