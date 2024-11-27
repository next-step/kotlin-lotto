package lotto

import lotto.domain.LottoCustomerInput
import lotto.domain.LottoNumber
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoNumbers
import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `일치한 갯수 별로 분류한다`() {
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(bonusNumber))
        val lottoNumberGenerator1 =
            LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 4, 5, 7)) }
        val lottoNumberGenerator2 = LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 6, 7, 8)) }

        assertThat(
            LottoResult.getLottoResult(
                LottoCustomerInput(2_000),
                winningNumbers,
                lottoNumberGenerator1,
            ).lottoOutcome.lottoRankMatchMap.lottoRankMatchMap.get(Rank.SECOND),
        ).isEqualTo(2)

        assertThat(
            LottoResult.getLottoResult(
                LottoCustomerInput(1_000),
                winningNumbers,
                lottoNumberGenerator2,
            ).lottoOutcome.lottoRankMatchMap.lottoRankMatchMap.get(Rank.FOURTH),
        ).isEqualTo(1)
    }

    @Test
    fun `수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다`() {
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(bonusNumber))
        val lottoNumberGenerator = { LottoNumbers.of(listOf(1, 2, 3, 4, 7, 8)) }

        val lottoCustomerInput = LottoCustomerInput(4_000)

        assertThat(
            LottoResult.getLottoResult(
                lottoCustomerInput,
                winningNumbers,
                lottoNumberGenerator,
            ).lottoOutcome.lottoProfitRate.profitRate,
        ).isEqualTo(50.0)
    }

    @Test
    fun `당첨 통계에 2등도 추가해야 한다`() {
        val bonusNumber = 7
        val numbers = listOf(1, 2, 3, 4, 5, 7)
        val winNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val purchasePrice = 1_000

        val winningNumbers = WinningNumbers(LottoNumbers(winNumber.toSet()), LottoNumber(bonusNumber))
        val lottoCustomerInput = LottoCustomerInput(purchasePrice)

        val lottoResult = LottoResult.getLottoResult(lottoCustomerInput, winningNumbers, { LottoNumbers.of(numbers) })

        assertThat(lottoResult.lottoOutcome.lottoRankMatchMap.lottoRankMatchMap.get(Rank.SECOND)).isEqualTo(1)
    }
}
