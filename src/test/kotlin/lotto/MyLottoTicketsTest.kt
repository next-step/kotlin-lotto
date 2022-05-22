package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MyLottoTicketsTest {

    @Test
    fun `구매한 로또의 당첨 결과를 확인한다`() {
        val myLotto = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val lastWinLotto = LottoTicket(listOf(1, 2, 3, 4, 5, 6))

        val myLottoTickets = MyLottoTickets(
            listOf(
                myLotto
            )
        )
        val lottoJudgment = LottoJudgment(lastWinLotto)
        val myLottoResult: MyLottoResult = myLottoTickets.getMyLottoResult(lottoJudgment)

        val expectedLottoResult = MyLottoResult(mapOf(LottoWinnerRank.FIRST_PRICE to 1))
        Assertions.assertThat(myLottoResult).isEqualTo(expectedLottoResult)
    }
}
