package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMatchingTest {
    @Test
    fun `로또 기계에 보너스 값을 전달한다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val lottoMachine = LottoMatching().apply {
            this.purchase(
                purchaseMoney = PurchaseMoney(1000),
                numbers = lottoNumbers
            )
            this.checkResult(
                winningLottoTicket = LottoTicket(lottoNumbers),
                bonusLottoNumber = LottoNumber(1)
            )
        }

        assertThat(lottoMachine.lottoTicketCount).isEqualTo(1)
        assertThat(lottoMachine.winningPrizes.prizes).isEqualTo(listOf(LottoResult.Prize.SIXTH))
    }

    @Test
    fun `보너스 일치 여부를 확인한다`() {
        assertThat(LottoTicket(numbers = (1..6).map { LottoNumber(it) }).hasBonusNumber(LottoNumber((1)))).isEqualTo(true)
    }
}
