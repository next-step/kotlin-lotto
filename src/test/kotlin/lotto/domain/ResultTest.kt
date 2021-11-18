package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun `등수 체크`() {
        assertThat(Result(listOf(MatchingCount(5, false), MatchingCount(5, true))).values)
            .isEqualTo(mapOf(Rank.MISS to 0, Rank.FIFTH to 0, Rank.FOURTH to 0, Rank.THIRD to 1, Rank.SECOND to 1, Rank.FIRST to 0))
    }

    @Test
    fun `이익 계산`() {
        assertThat(Result(listOf(MatchingCount(3, false))).calculateProfit(Money.makeForBuyingLotto(5000)))
            .isEqualTo(1.00)
        assertThat(Result(listOf(MatchingCount(6, false))).calculateProfit(Money.makeForBuyingLotto(1000)))
            .isEqualTo(2000000.0)
    }
}
