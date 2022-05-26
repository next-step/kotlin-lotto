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
                bonusLottoNumber = LottoNumber(7)
            )
        }

        assertThat(lottoMachine.lottoTicketCount).isEqualTo(1)
        assertThat(lottoMachine.winningPrizes.prizes).isEqualTo(listOf(LottoResult.Prize.SIXTH))
    }

    @Test
    fun `로또 Prize을 확인하기 위하여 당첨 번호, 보너스 일치 여부를 전달한다`() {
        val lottoMachine = LottoMatching().apply {
            this.purchase(
                purchaseMoney = PurchaseMoney(1000),
                numbers = (1..6).map { LottoNumber(it) }
            )
            this.checkResult(
                winningLottoTicket = LottoTicket((2..7).map { LottoNumber(it) }),
                bonusLottoNumber = LottoNumber(1)
            )
        }

        assertThat(lottoMachine.lottoTicketCount).isEqualTo(1)
        assertThat(lottoMachine.winningPrizes.prizes).isEqualTo(listOf(LottoResult.Prize.FIFTH_BONUS))
    }
}
