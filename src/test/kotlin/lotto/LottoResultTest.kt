package lotto

import lotto.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `일치한 갯수 별로 분류한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator1 =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoNumberGenerator2 = LottoNumberGenerator { listOf(1, 2, 3, 6, 7) }
        val lottoMachine1 = LottoMachine(lottoNumberGenerator1)
        val lottoMachine2 = LottoMachine(lottoNumberGenerator2)

        val lottos1 = lottoMachine1.makeLottos(2)
        val lottos2 = lottoMachine2.makeLottos(1)
        assertThat(LottoResult.getResultMap(lottos1, winningNumbers).get(4)).isEqualTo(2)
        assertThat(LottoResult.getResultMap(lottos2, winningNumbers).get(3)).isEqualTo(1)
    }

    @Test
    fun `갯수별 금액과 갯수를 곱해 수익금을 만든다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val resultMap = LottoResult.getResultMap(lottos, winningNumbers)

        assertThat(LottoResult.getProfitMap(resultMap)).contains(entry(4, 200_000))
    }

    @Test
    fun `수익금을 구매금액으로 나누어 수익률을 구한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator = LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val resultMap = LottoResult.getResultMap(lottos, winningNumbers)
        val profitMap = LottoResult.getProfitMap(resultMap)
        assertThat(LottoResult.getProfit(profitMap)).isEqualTo(200_000)
    }

    @Test
    fun `수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)
        val resultMap = LottoResult.getResultMap(lottos, winningNumbers)
        val profitMap = LottoResult.getProfitMap(resultMap)
        val profit = LottoResult.getProfit(profitMap)
        assertThat(LottoResult.getProfitRate(profit, 4_000)).isEqualTo(50.0)
    }
}
