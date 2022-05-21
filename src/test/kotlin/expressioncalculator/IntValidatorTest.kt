package expressioncalculator

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class IntValidatorTest {
    @ParameterizedTest
    @NullSource
    fun `IntValidator가 null을 전달받을 경우, RuntimeException이 발생한다`(input: Int?) {
        assertThrows<RuntimeException> { IntValidator.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 1, 0, 100, -20])
    fun `IntValidator가 음수를 전달받을 경우, RuntimeException이 발생한다`(input: Int) {
        if (input < 0) {
            assertThrows<RuntimeException> { IntValidator.validate(input) }
        } else {
            assertDoesNotThrow { IntValidator.validate(input) }
        }
    }
}
