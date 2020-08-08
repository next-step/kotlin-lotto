package lotto.domain

import lotto.domain.PrizeMoney.Companion.getRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeMoneyTest {
    @Test
    fun get_rank() {
        assertThat(getRank(6, false)).isEqualTo(PrizeMoney.FIRST)
        assertThat(getRank(5, true)).isEqualTo(PrizeMoney.SECOND)
        assertThat(getRank(5, false)).isEqualTo(PrizeMoney.THIRD)
        assertThat(getRank(4, false)).isEqualTo(PrizeMoney.FOURTH)
        assertThat(getRank(3, false)).isEqualTo(PrizeMoney.FIFTH)
        assertThat(getRank(0, false)).isEqualTo(PrizeMoney.MISS)
    }

    @Test
    fun get_total_money() {
        assertThat(PrizeMoney.FIFTH.totalMoney(3)).isEqualTo(15_000)
    }
}
