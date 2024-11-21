package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryStatisticianTest {

    @Test
    fun `6개의 수가 맞으면 1등이다`() {
        // given
        val targetLottoStr = "1, 2, 3, 4, 5, 6"
        val statistician = LotteryStatistician(targetLottoStr)

        // when
        val result = statistician.statistics(
            listOf(Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)))
        )

        // then
        assertThat(result.statistics[LottoRank.FIRST]).isEqualTo(1)
        assertThat(result.statistics[LottoRank.SECOND]).isEqualTo(0)
        assertThat(result.statistics[LottoRank.THIRD]).isEqualTo(0)
        assertThat(result.statistics[LottoRank.FOURTH]).isEqualTo(0)
    }

}
