package lotto.domain.money

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WonTest {
    @Test
    fun `금액을 받아 단위와 함께 표시한다`() {
        assertThat(Won(1000).displayValue).isEqualTo("1000원")
    }

    @Test
    fun `대소 비교를 할 수 있다`() {
        assertThat(Won(1000) > Won(500)).isEqualTo(true)
    }
}
