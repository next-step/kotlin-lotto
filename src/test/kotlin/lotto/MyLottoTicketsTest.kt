package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyLottoTicketsTest {

    @Test
    fun `구매한 로또의 당첨 결과를 확인한다`() {
        val myLotto = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val lastWinLotto = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 45

        val myLottoTickets = MyLottoTickets(
            listOf(
                myLotto
            )
        )
        val lottoJudgment = LottoJudgment(lastWinLotto, bonusNumber)
        val myLottoResult: MyLottoResult = myLottoTickets.getMyLottoResult(lottoJudgment)

        val expectedLottoResult = MyLottoResult(mapOf(LottoWinnerRank.FIRST_PRICE to 1))
        assertThat(myLottoResult).isEqualTo(expectedLottoResult)
    }

    @Test
    fun `당첨로또에 대한 이익률 을 계산한다`() {
        val myLottos = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        )
        val myLottoTickets = MyLottoTickets(myLottos)

        val myProfilt = myLottoTickets.getProfit(MyLottoResult(mapOf(LottoWinnerRank.FIFTH_PRICE to 1)))

        assertThat(myProfilt).isEqualTo(((5000).toDouble() / (3 * 1000).toDouble()))
    }
}
