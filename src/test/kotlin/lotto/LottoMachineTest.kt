package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {

    @Test
    internal fun `로또 발행`() {
        val lottoPay = 1000
        val amount = 10000
        val lottoPrizeInfo = LottoPrizeInfo(
            listOf(
                LottoPrizeData(3, 5000),
                LottoPrizeData(4, 50000),
                LottoPrizeData(5, 1500000),
                LottoPrizeData(6, 2000000000)
            )
        )
        val lottoMachine = LottoMachine(lottoPay, lottoPrizeInfo)
        val lottoDataList: List<LottoData> = lottoMachine.issue(amount)
        assertThat(lottoDataList.size).isEqualTo(10)
    }
}
