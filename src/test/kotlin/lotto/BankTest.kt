package lotto

import lotto.domain.Bank
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoSeller
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test

class BankTest {
    @Test
    fun `갯수별 금액과 갯수를 곱해 수익금을 만든다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val resultMap = LottoResult.getResultMap(lottos, winningNumbers)

        assertThat(Bank().getProfitMap(resultMap)).contains(entry(4, 200_000))
    }

    @Test
    fun `수익금을 구매금액으로 나누어 수익률을 구한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator = LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val resultMap = LottoResult.getResultMap(lottos, winningNumbers)
        val profitMap = Bank().getProfitMap(resultMap)
        assertThat(Bank().getProfit(profitMap)).isEqualTo(200_000)
    }

    @Test
    fun `수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val resultMap = LottoResult.getResultMap(lottos, winningNumbers)
        val profitMap = Bank().getProfitMap(resultMap)
        val profit = Bank().getProfit(profitMap)
        assertThat(Bank().getProfitRate(profit, 4_000)).isEqualTo(50.0)
    }
}
