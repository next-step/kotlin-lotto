import lotto.domain.LottoMoney
import lotto.domain.LottoRank
import lotto.domain.LottoResults
import lotto.domain.LottoResults.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Test
    fun `calculateBuyingMoney는 로또 개수에 따라 구매 금액을 계산한다`() {
        val results = listOf(
            LottoResult(LottoRank.FIRST, 1),
            LottoResult(LottoRank.THIRD, 2),
        )
        val lottoResults = LottoResults(results)

        assertThat(lottoResults.calculateBuyingMoney()).isEqualTo(3 * LottoMoney.LOTTO_COST)
    }

    @Test
    fun `calculateEarningMoney는 로또 결과의 총 상금을 계산한다`() {
        val results = listOf(
            LottoResult(LottoRank.FIRST, 1),
            LottoResult(LottoRank.THIRD, 2),
        )
        val lottoResults = LottoResults(results)

        val expectedEarnings = LottoRank.FIRST.winningMoney * 1 + LottoRank.THIRD.winningMoney * 2
        assertThat(lottoResults.calculateEarningMoney()).isEqualTo(expectedEarnings)
    }

    @Test
    fun `calculateRateOfReturn은 수익률을 계산한다`() {
        val results = listOf(
            LottoResult(LottoRank.FIRST, 1),
            LottoResult(LottoRank.THIRD, 2),
        )
        val lottoResults = LottoResults(results)

        val expectedRateOfReturn =
            (LottoRank.FIRST.winningMoney * 1 + LottoRank.THIRD.winningMoney * 2).toDouble() /
                (lottoResults.buyingLottoCount() * LottoMoney.LOTTO_COST)

        assertThat(lottoResults.calculateRateOfReturn()).isEqualTo(expectedRateOfReturn)
    }

    @Test
    fun `isProfitable은 수익률이 1보다 크면 true를 반환한다`() {
        val profitableResults = LottoResults(
            listOf(
                LottoResult(LottoRank.FIRST, 1),
                LottoResult(LottoRank.NONE, 0),
            ),
        )
        assertThat(profitableResults.isProfitable).isTrue
    }

    @Test
    fun `isProfitable은 수익률이 1보다 작으면 false를 반환한다`() {
        val unprofitableResults = LottoResults(
            listOf(
                LottoResult(LottoRank.NONE, 10),
            ),
        )
        assertThat(unprofitableResults.isProfitable).isFalse
    }

    @Test
    fun `getWiningResults는 당첨된 결과만 반환한다`() {
        val results = listOf(
            LottoResult(LottoRank.FIRST, 1),
            LottoResult(LottoRank.THIRD, 2),
            LottoResult(LottoRank.NONE, 5),
        )
        val lottoResults = LottoResults(results)

        val winningResults = lottoResults.getWiningResults()
        assertThat(winningResults).containsExactlyInAnyOrder(
            LottoResult(LottoRank.FIRST, 1),
            LottoResult(LottoRank.THIRD, 2),
        )
    }
}
