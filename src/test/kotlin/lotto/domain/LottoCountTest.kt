package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoCountTest {
    @Test
    fun `부등식 테스트`() {
        val a = LottoCount.from(1)
        val b = LottoCount.from(2)

        assertThat(a).isLessThan(b)
        assertThat(a < b).isTrue()
        assertThat(b).isGreaterThan(a)
        assertThat(a > b).isFalse()
    }

    @Test
    fun `0일땐 비어있는 것으로 처리 테스트`() {
        val lotto = LottoCount.from(0)

        assertThat(lotto.isEmpty()).isTrue()
    }

    @Test
    fun `음수로 입력되면 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            LottoCount.from(-1)
        }
    }
}
