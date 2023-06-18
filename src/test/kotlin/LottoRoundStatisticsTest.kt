import Money.Companion.toMoney
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRoundStatisticsTest {

    @Test
    fun `당첨된 로또를 기준으로 추첨 상세결과를 확인할 수 있다`() {
        // given
        val lotto = (1..6).map { LottoNumber(it) }.toList().let{ Lotto(it) }
        val winningLotto = (1..6).map { LottoNumber(it) }.toList().let{ Lotto(it) }
        val sut = LottoRoundStatistics(listOf(lotto), winningLotto)

        // when
        // then
        assertThat(sut.lottoResults.size).isEqualTo(1)
        assertThat(sut.lottoResults.first().lotto).isEqualTo(lotto)
        assertThat(sut.lottoResults.first().winningLotto).isEqualTo(winningLotto)
        assertThat(sut.lottoResults.first().sameNumberCount).isEqualTo(6)
        assertThat(sut.lottoResults.first().reward).isEqualTo(LottoReward.WINNER_1ST)
        assertThat(sut.totalPrize).isEqualTo(LottoReward.WINNER_1ST.prize.toMoney())
    }

}