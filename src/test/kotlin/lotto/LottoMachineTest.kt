package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @Test
    fun `로또 기계에 보너스 값을 전달한다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val lottoMachine = LottoMachine().apply {
            this.purchase(
                purchaseMoney = PurchaseMoney(1000),
                randomNumberFunc = { lottoNumbers }
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
        val lottoMachine = LottoMachine().apply {
            this.purchase(
                purchaseMoney = PurchaseMoney(1000),
                randomNumberFunc = { (1..6).map { LottoNumber(it) } }
            )
            this.checkResult(
                winningLottoTicket = LottoTicket((2..7).map { LottoNumber(it) }),
                bonusLottoNumber = LottoNumber(1)
            )
        }

        assertThat(lottoMachine.lottoTicketCount).isEqualTo(1)
        assertThat(lottoMachine.winningPrizes.prizes).isEqualTo(listOf(LottoResult.Prize.FIFTH_BONUS))
    }

    @Test
    fun `보너스 번호는 없으며 당첨번호 3개로 구성된 내용을 확인한다`() {
        val lottoMachine = LottoMachine().apply {
            this.purchase(
                purchaseMoney = PurchaseMoney(1000),
                randomNumberFunc = { (1..6).map { LottoNumber(it) } }
            )
            this.checkResult(
                winningLottoTicket = LottoTicket((4..9).map { LottoNumber(it) }),
                bonusLottoNumber = LottoNumber(1)
            )
        }

        assertThat(lottoMachine.lottoTicketCount).isEqualTo(1)
        assertThat(lottoMachine.winningPrizes.prizes).isEqualTo(listOf(LottoResult.Prize.THIRD))
    }
}
