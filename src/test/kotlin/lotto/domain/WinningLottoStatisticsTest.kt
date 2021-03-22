package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningLottoStatisticsTest {

    @ParameterizedTest
    @CsvSource(
        "10000000, 200.0055",
        "100000000, 20.00055",
        "1000000000, 2.000055"
    )
    fun `1등, 3등, 4등에 당첨되었을 때 구매금액에 따른 수익률 계산`(price: Int, expectedProfitRate: Double) {
        val winningLottoNumbers = WinningLottoNumbers.of(listOf(1, 2, 3, 4, 5, 6), 7)

        val manual = listOf(
            Lotto.from(LottoNumberTokenizer.tokenize("1,2,3,4,5,6").map { LottoNumber.from(it) }),
            Lotto.from(LottoNumberTokenizer.tokenize("11,12,13,4,5,6").map { LottoNumber.from(it) }),
            Lotto.from(LottoNumberTokenizer.tokenize("3,4,5,6,41,42").map { LottoNumber.from(it) })
        )

        val lottoTicket = LottoTicket(manual, listOf())

        val winningLottoStatistics = WinningLottoStatistics(lottoTicket, winningLottoNumbers)
        val lottoProfitRate = winningLottoStatistics.calculateProfitRate(LottoPrice(price))
        assertThat(lottoProfitRate.profitRate).isEqualTo(expectedProfitRate)
    }
}
