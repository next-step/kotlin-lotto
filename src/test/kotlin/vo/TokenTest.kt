package vo

import calculator.vo.Token
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TokenTest {
    @Test
    @DisplayName("Token에 음수가 들어오면 예외가 발생한다")
    internal fun negativeNumberNotAllowedTest() {
        assertThrows<RuntimeException> {
            Token(-1)
        }
    }

    @ParameterizedTest
    @CsvSource("a", "@", "한글")
    @DisplayName("Token이 integer type이 아니면 예외가 발생한다")
    internal fun notIntegerTypeNotAllowedTest(input: String) {
        assertThrows<RuntimeException> {
            Token.of(input)
        }
    }
}
