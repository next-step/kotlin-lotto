package caculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class NumbersTest {
    @Test
    fun `생성자에 음수가 포함된 경우 예외를 던진다`() {
        assertThatThrownBy { Numbers(listOf(1, -1)) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("잘못된 입력입니다. 양수만 입력해주세요.")
    }

    @Test
    fun `생성자에 숫자가 아닌 값이 포함된 경우 예외를 던진다`() {
        assertThatThrownBy { Numbers(listOf("1", "a")) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("잘못된 입력입니다. 숫자만 입력해주세요.")
    }

    @Test
    fun `숫자들의 합을 구한다`() {
        assertThat(Numbers(listOf(1, 2, 3)).sum()).isEqualTo(6)
    }
}
