package calculator

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositiveNumberTest {
    @DisplayName(value = "음수 입력값에 대해 convertTokensToNum 함수가 예외를 처리한다")
    @Test
    fun checkNegativeNumbers() {
        val numbers = listOf(1,2,-3)
        assertThrows<RuntimeException> {
            PositiveNumber(numbers)
        }
    }
}
