package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import kotlin.RuntimeException

class TokenTest {
    @Test
    fun `토큰이 양수면 Int 값으로 반환한다`() {
        assertThat(Token("123").number).isEqualTo(123)
    }

    @Test
    fun `토큰이 숫자가 아니면 RuntimeException을 던진다`() {
        assertThatThrownBy { Token("love") }
            .isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `토큰이 음수면 RuntimeException을 던진다`() {
        assertThatThrownBy { Token("-1") }
            .isInstanceOf(RuntimeException::class.java)
    }
}
