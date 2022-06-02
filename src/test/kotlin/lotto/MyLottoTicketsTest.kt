package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyLottoTicketsTest {

    @Test
    fun `구매한 로또의 당첨 결과를 확인한다`() {
        val myLotto = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lastWinLotto = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(45)

        val myLottoTickets = MyLottoTickets(
            listOf(
                myLotto
            )
        )
        val lottoJudgment = LastWinningLotto(lastWinLotto, bonusNumber)
        val myLottoResult: MyLottoResult = myLottoTickets.getMyLottoResult(lottoJudgment)

        val expectedLottoResult = MyLottoResult(mapOf(LottoWinnerRank.FIRST_PRICE to 1))
        assertThat(myLottoResult).isEqualTo(expectedLottoResult)
    }
}
