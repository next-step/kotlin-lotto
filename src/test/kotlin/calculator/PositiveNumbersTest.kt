package calculator

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositiveNumbersTest {
    @DisplayName(value = "음수 입력값에 대해 convertTokensToNum 함수가 예외를 처리한다")
    @Test
    fun checkNegativeNumbers() {
        val numbers = listOf("1", "2", "-3")
        assertThrows<RuntimeException> {
            PositiveNumbers(numbers)
        }
    }

    @DisplayName(value = "올바르지 않은 입력값에 대해 convertTokensToNum 함수가 예외를 처리한다")
    @Test
    fun checkInvalidNumbers() {
        val numbers = listOf("1", "2", "@")
        assertThrows<RuntimeException> {
            PositiveNumbers(numbers)
        }
    }
}
