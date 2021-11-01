package calculator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class PositiveIntTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1])
    fun `양의 정수 생성`(value: Int) {
        assertDoesNotThrow {
            PositiveInt(value)
        }
    }

    @Test
    fun `문자로부터 양의 정수 생성`() {
        assertDoesNotThrow {
            PositiveInt("0")
        }
    }

    @Test
    fun `숫자가 아닌 경우 예외`() {
        assertThrows<RuntimeException> {
            PositiveInt("a")
        }
    }

    @Test
    fun `양의 정수가 아닌 경우 예외`() {
        assertThrows<RuntimeException> {
            PositiveInt(-1)
        }
    }
}
