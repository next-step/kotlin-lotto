package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoStatisticsTest {

    @Test
    fun `등수 결과로 당첨 통계의 수익율을 계산한다`() {
        val matchResult = mapOf(Rank.FOURTH to 1, Rank.FIFTH to 2, Rank.MISS to 5)
        val lottoStatistics = LottoStatistics(matchResult)
        assertThat(lottoStatistics.getRateOfReward()).isEqualTo(7.5)
    }
}
