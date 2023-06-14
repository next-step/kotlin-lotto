package string.add.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `0 이하 음수가 입력되면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Number(-1)
        }
    }

    @Test
    fun `양수가 입력되면 해당 숫자에 접근할 수 있다`() {
        assertThat(Number(1).value).isEqualTo(1)
    }
}
