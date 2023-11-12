package stringAddCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TokenTest {
    @ValueSource(strings = ["1", "2", "3"])
    @ParameterizedTest
    fun `토큰값이 양의 숫자형일 때 정상적으로 Token이 생성됨`(value: String) { // given
        // when
        val token = Token.of(value)
        // then
        assertThat(token.value).isEqualTo(value.toInt())
    }

    @ValueSource(strings = ["-1", "-2", "-3"])
    @ParameterizedTest
    fun `토큰값이 음수일 때 IllegalArgumentException 발생`(value: String) { // given
        // when
        assertThrows<IllegalArgumentException> { // then
            Token.of(value) // when
        }.also {
            assertThat(it.message).isEqualTo("토큰 값으로 음수는 들어올 수 없습니다.")
        }
    }

    @ValueSource(strings = ["1/2@3", "안녕", "하세요", "?"])
    @ParameterizedTest
    fun `토근값이 숫자형이 아닐 때 IllegalArgumentException 발생`(value: String) { // given
        assertThrows<IllegalArgumentException> { // then
            Token.of(value) // when
        }.also {
            assertThat(it.message).isEqualTo("토큰 값은 숫자여야 합니다.")
        }
    }
}
