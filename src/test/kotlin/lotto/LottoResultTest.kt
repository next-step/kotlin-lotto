package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoNumbers
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
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5)))
        val lottoNumberGenerator1 =
            LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 4, 7)) }
        val lottoNumberGenerator2 = LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 6, 7)) }

        val lottoSeller1 = LottoSeller(lottoNumberGenerator1)
        val lottoSeller2 = LottoSeller(lottoNumberGenerator2)

        val lottos1 = lottoSeller1.sellLottos(2_000)
        val lottos2 = lottoSeller2.sellLottos(1_000)
        assertThat(
            LottoResult.getLottoResult(
                lottos1,
                winningNumbers,
                bonusNumber,
            ).lottoMatchMap.lottoMatchMap.get(Rank.FOURTH),
        ).isEqualTo(2)

        assertThat(
            LottoResult.getLottoResult(
                lottos2,
                winningNumbers,
                bonusNumber,
            ).lottoMatchMap.lottoMatchMap.get(Rank.FIFTH),
        ).isEqualTo(1)
    }

    @Test
    fun `수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다`() {
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5)))
        val lottoNumberGenerator =
            LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 4, 7)) }

        val lottoSeller = LottoSeller(lottoNumberGenerator)
        val lottos = lottoSeller.sellLottos(4_000)

        assertThat(LottoResult.getLottoResult(lottos, winningNumbers, bonusNumber).profitRate).isEqualTo(50.0)
    }

    @Test
    fun `당첨 통계에 2등도 추가해야 한다`() {
        val bonusNumber = 7
        val numbers = listOf(1, 2, 3, 4, 5, 7)
        val winNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val purchasePrice = 1_000

        val winningNumbers = WinningNumbers(LottoNumbers(winNumber))
        val lottoSeller = LottoSeller { LottoNumbers.of(numbers) }
        val lottos = lottoSeller.sellLottos(purchasePrice)
        val lottoResult = LottoResult.getLottoResult(lottos, winningNumbers, bonusNumber)

        assertThat(lottoResult.lottoMatchMap.lottoMatchMap.get(Rank.SECOND)).isEqualTo(1)
    }
}
