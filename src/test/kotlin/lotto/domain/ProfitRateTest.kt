package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfitRateTest {

    @Test
    fun `구매금액 대비 당첨금액의 수익률을 계산한다`() {
        // given
        val matchResult = mapOf(
            Ranking.FIRST to 0,
            Ranking.SECOND to 0,
            Ranking.THIRD to 0,
            Ranking.FOURTH to 1
        )

        val price = 14000

        // when
        val actual = ProfitRate(matchResult, price).calculate()

        // then
        val expected = 0.35
        assertThat(actual).isEqualTo(expected)
    }
}
