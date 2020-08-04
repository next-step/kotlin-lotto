package lotto.domain.value

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun `음수가 들어올 경우 IllegalArgumentException이 발생해야한다`() {
        assertThatThrownBy { Money(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음수는 Money로 사용될 수 없습니다.")
    }
}
