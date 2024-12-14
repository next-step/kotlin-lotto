package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또 티켓은 구입금액은 1_000원 이상이여야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoTickets.purchase(900)
        }.also {
            it.message shouldBe "구입금액은 1000원 이상이여야 합니다"
        }
    }

    @Test
    fun `로또 티켓을 구입 금액에 맞게 발급한다`() {
        val amount = 5_000
        val lottoTickets = LottoTickets.purchase(amount)
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
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoResults = lottoTickets.calculateLottoRank(winningLotto)
        val sortedResults = lottoResults.findAllSortedByMatchCount()
        sortedResults[0].rank shouldBe LottoRank.FIRST_PLACE
        sortedResults[0].count shouldBe 0
        sortedResults[1].rank shouldBe LottoRank.SECOND_PLACE
        sortedResults[1].count shouldBe 2
        sortedResults[2].rank shouldBe LottoRank.THIRD_PLACE
        sortedResults[2].count shouldBe 1
    }
}
