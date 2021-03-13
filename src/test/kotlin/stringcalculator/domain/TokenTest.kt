package stringcalculator.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TokenTest {

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-3", "-4", "-11", "-15"])
    fun `음수 문자열이 입력되면 예외를 던진다`(numberString: String) {
        assertThrows<RuntimeException> {
            Token.from(numberString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "c", "hello", "world"])
    fun `숫자로 변환될 수 없는 문자는 예외를 던진다`(fakeNumberString: String) {
        assertThrows<RuntimeException> {
            Token.from(fakeNumberString)
        }
    }
}
