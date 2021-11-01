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
        // given
        val value = "0"

        // when
        val create = { PositiveInt(value) }

        // then
        assertDoesNotThrow(create)
    }

    @Test
    fun `숫자가 아닌 경우 예외`() {
        // given
        val value = "a"

        // when
        val create: () -> Unit = { PositiveInt(value) }

        // then
        assertThrows<RuntimeException>(create)
    }

    @Test
    fun `양의 정수가 아닌 경우 예외`() {
        // given
        val value = -1

        // when
        val create: () -> Unit = { PositiveInt(value) }

        // then
        assertThrows<RuntimeException>(create)
    }
}
