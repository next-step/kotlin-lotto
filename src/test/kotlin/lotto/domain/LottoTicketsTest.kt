package lotto.domain

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `자동 로또 티켓은 구입 수량이 0개이상이여야 발급되는 로또 티켓은 0개이다`() {
        val autoLottoTickets = LottoTickets.generateAutoLottoTickets(0)
        autoLottoTickets.size shouldBe 0
    }

    @Test
    fun `로또 티켓을 구입 수량에 맞게 발급한다`() {
        val lottoTickets = LottoTickets.generateAutoLottoTickets(5)
        lottoTickets shouldHaveSize 5
    }

    @Test
    fun `당첨 티켓을 전달하면 당첨 결과를 확인 할 수 있다`() {
        val lottoTickets =
            LottoTickets(
                listOf(
                    LottoTicket.from(setOf(1, 2, 3, 4, 5, 7)),
                    LottoTicket.from(setOf(1, 2, 3, 4, 5, 9)),
                    LottoTicket.from(setOf(1, 2, 3, 4, 8, 9)),
                ),
            )
        val winningLotto = WinningLotto(LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(7))
        val lottoResults = lottoTickets.calculateLottoRank(winningLotto)
        val sortedResults = lottoResults.findAllSortedByPrize()
        sortedResults[0].rank shouldBe LottoRank.BLANK_PLACE
        sortedResults[0].count shouldBe 0
        sortedResults[1].rank shouldBe LottoRank.FIFTH_PLACE
        sortedResults[1].count shouldBe 0
        sortedResults[2].rank shouldBe LottoRank.FOURTH_PLACE
        sortedResults[2].count shouldBe 1
        sortedResults[3].rank shouldBe LottoRank.THIRD_PLACE
        sortedResults[3].count shouldBe 1
        sortedResults[4].rank shouldBe LottoRank.SECOND_PLACE
        sortedResults[4].count shouldBe 1
        sortedResults[5].rank shouldBe LottoRank.FIRST_PLACE
        sortedResults[5].count shouldBe 0
    }
}
