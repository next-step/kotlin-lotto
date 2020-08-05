package lotto.domain

import lotto.domain.PrizeMoney.Companion.getPrizeMoney
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrizeMoneyTest {

    @DisplayName("매칭성공 개수에 맞는 알맞은 상을 반환한다")
    @Test
    fun `match prize`() {
        assertThat(getPrizeMoney(3)).isEqualTo(PrizeMoney.FOURTH)
        assertThat(getPrizeMoney(4)).isEqualTo(PrizeMoney.THIRD)
        assertThat(getPrizeMoney(5)).isEqualTo(PrizeMoney.SECOND)
        assertThat(getPrizeMoney(6)).isEqualTo(PrizeMoney.FIRST)
    }
    @DisplayName("매칭성공 개수에 맞는 알맞은 당첨금을 반환한다")
    @Test
    fun `get prize money`() {
        assertThat(getPrizeMoney(3).money).isEqualTo(5000)
        assertThat(getPrizeMoney(4).money).isEqualTo(50_000)
        assertThat(getPrizeMoney(5).money).isEqualTo(1_500_000)
        assertThat(getPrizeMoney(6).money).isEqualTo(2_000_000_000)
    }
}
