package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    internal fun calculateTotalPrize() {
        val lottoResult = LottoResult(mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 0,
            Rank.THIRD to 2,
            Rank.FORTH to 5,
            Rank.FIFTH to 10,
            Rank.MISS to 0
        ))

        val totalPrize = lottoResult.calculateTotalPrize()
        assertThat(totalPrize).isEqualTo(3_300_000)
    }
}
