package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `operator로 누적 Rank 갯수를 가져오거나 입력할 수 있다`() {
        val result = LottoResult().also {
            it[Rank.FIRST_PRIZE]++
            it[Rank.SECOND_PRIZE] = 2
            it[Rank.NONE] = 4
        }

        assertThat(result).satisfies {
            assertThat(it[Rank.FIRST_PRIZE]).isEqualTo(1)
            assertThat(it[Rank.SECOND_PRIZE]).isEqualTo(2)
            assertThat(it[Rank.THIRD_PRIZE]).isEqualTo(0)
            assertThat(it[Rank.NONE]).isEqualTo(4)
        }
    }

    @Test
    fun `collectAllPrizes() 당첨 합계 금액`() {
        val result = LottoResult().also {
            it[Rank.FIRST_PRIZE]++
            it[Rank.SECOND_PRIZE]++
            it[Rank.THIRD_PRIZE]++
            it[Rank.FOURTH_PRIZE]++
            it[Rank.FIFTH_PRIZE]++
            it[Rank.NONE] = 5
        }

        assertThat(result.collectAllPrizes()).isEqualTo(2031555000)
    }

    @Test
    fun `totalProfitRate() 총 로또 비용대비 수익률 계산`() {
        val result = LottoResult().also {
            it[Rank.FIRST_PRIZE]++
            it[Rank.SECOND_PRIZE]++
            it[Rank.THIRD_PRIZE]++
            it[Rank.FOURTH_PRIZE]++
            it[Rank.FIFTH_PRIZE]++
            it[Rank.NONE] = 5
        }

        assertThat(result.totalProfitRate()).isEqualTo(203155.5f)
    }
}
