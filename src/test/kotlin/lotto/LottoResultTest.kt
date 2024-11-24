package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoSeller
import lotto.domain.Rank
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `일치한 갯수 별로 분류한다`() {
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator1 =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoNumberGenerator2 = LottoNumberGenerator { listOf(1, 2, 3, 6, 7) }
        val lottoMachine1 = LottoMachine(lottoNumberGenerator1)
        val lottoMachine2 = LottoMachine(lottoNumberGenerator2)

        val lottos1 = lottoMachine1.makeLottos(2)
        val lottos2 = lottoMachine2.makeLottos(1)
        assertThat(LottoResult.getLottoMatchMap(lottos1, winningNumbers, bonusNumber).lottoMatchMap.get(Rank.FOURTH)).isEqualTo(2)
        assertThat(LottoResult.getLottoMatchMap(lottos2, winningNumbers, bonusNumber).lottoMatchMap.get(Rank.FIFTH)).isEqualTo(1)
    }

    @Test
    fun `수익금을 구매금액으로 나누어 수익률을 구한다`() {
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator = LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val lottoMatchMap = LottoResult.getLottoMatchMap(lottos, winningNumbers, bonusNumber)
        assertThat(LottoResult.getProfit(lottoMatchMap)).isEqualTo(200_000)
    }

    @Test
    fun `수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다`() {
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val lottoMatchMap = LottoResult.getLottoMatchMap(lottos, winningNumbers, bonusNumber)
        val profit = LottoResult.getProfit(lottoMatchMap)
        assertThat(LottoResult.getProfitRate(profit, 4_000)).isEqualTo(50.0)
    }

    @Test
    fun `당첨 통계에 2등도 추가해야 한다`() {
        val bonusNumber = 7
        val numbers = listOf(1, 2, 3, 4, 5, 7)
        val winNumber = listOf(1, 2, 3, 4, 5, 6)
        val purchasePrice = 1_000

        val winningNumbers = WinningNumbers(winNumber)
        val lottoSeller = LottoSeller { numbers }
        val lottos = lottoSeller.sellLottos(purchasePrice)
        val lottoResult = LottoResult.getLottoResult(lottos, winningNumbers, bonusNumber, purchasePrice)

        assertThat(lottoResult.lottoMatchMap.lottoMatchMap.get(Rank.SECOND)).isEqualTo(1)
    }
}
