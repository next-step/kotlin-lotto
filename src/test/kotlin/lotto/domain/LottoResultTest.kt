package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {
    @Test
    fun calculateTotalRate() {
        val lottoResult = LottoResult(
            mapOf(
                Rank.FIRST to 0,
                Rank.SECOND to 0,
                Rank.THIRD to 2,
                Rank.FOURTH to 5,
                Rank.FIFTH to 10,
                Rank.MISS to 0
            )
        )

        val totalPrize = lottoResult.calculateTotalRate(Money(33_000))
        assertThat(totalPrize).isEqualTo(Money(100).toBigDecimal())
    }
}
