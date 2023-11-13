package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `로또 번호와 당첨정보를 받아 알맞은 등수를 반환한다`() {
        assertThat(Prize.getPrize(0, false)).isEqualTo(Prize.NO_PRIZE)
        assertThat(Prize.getPrize(1, false)).isEqualTo(Prize.NO_PRIZE)
        assertThat(Prize.getPrize(2, false)).isEqualTo(Prize.NO_PRIZE)
        assertThat(Prize.getPrize(3, false)).isEqualTo(Prize.FIFTH)
        assertThat(Prize.getPrize(4, false)).isEqualTo(Prize.FOURTH)
        assertThat(Prize.getPrize(5, false)).isEqualTo(Prize.THIRD)
        assertThat(Prize.getPrize(6, false)).isEqualTo(Prize.FIRST)

        assertThat(Prize.getPrize(5, true)).isEqualTo(Prize.SECOND)
    }
}
