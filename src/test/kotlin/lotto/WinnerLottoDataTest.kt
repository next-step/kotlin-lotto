package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerLottoDataTest {

    @Test
    fun `로또 데이터 Test`() {
        val paymentAmount = 14000
        val lottoPrizeInfo = LottoPrizeInfo(
            listOf(
                LottoPrizeData(3, 5000),
                LottoPrizeData(4, 50000),
                LottoPrizeData(5, 1500000),
                LottoPrizeData(6, 2000000000)
            )
        )
        val lottoData = LottoData(listOf(1, 2, 3, 4, 5, 6))
        lottoData.match(listOf(1, 2, 3, 12, 13, 14))
        val winnerLottoData = WinnerLottoData(listOf(lottoData), lottoPrizeInfo, paymentAmount)

        val prizeRate = winnerLottoData.getPrizeRate()
        assertThat(prizeRate).isEqualTo(0.35)
    }
}
