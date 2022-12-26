package lotto.domain

import lotto.model.LottoPrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeResultsTest {
    @Test
    fun `각 등수의 담청 된 개수와 총 당첨 금액을 알 수 있다`() {
        // given
        val prize = LottoPrize.FIRST
        val results = listOf(prize)
        val lottoPrizeResults = LottoPrizeResults(results)

        // when
        val count = lottoPrizeResults.count(prize)
        val totalPrize = lottoPrizeResults.totalPrize()

        // then
        assertThat(count).isEqualTo(1)
        assertThat(totalPrize).isEqualTo(prize.prize)
    }
}
