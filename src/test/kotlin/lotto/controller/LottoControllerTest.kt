package lotto.controller

import io.kotest.matchers.shouldBe
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Test

class LottoControllerTest {
    @Test
    fun `구입 금액을 입력하면 로또 티켓이 천원당 1장으로 여러개의 로또 티켓이 발급된다`() {
        val lottoTickets = LottoController.purchaseLotto(10000)
        lottoTickets.size shouldBe 10
    }

    @Test
    fun `로또 티켓 목록과 당첨 티켓을 전달하면 당첨 결과를 확인 할 수 있다`() {
        val lottoTickets = LottoTickets(listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6))))
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoResults = LottoController.calculateLottoRank(lottoTickets, winningLotto)
        lottoResults.getResults()
            .sortedByDescending { it.count }
            .take(1)
            .map {
                it.rank shouldBe LottoRank.FIRST_PLACE
            }
    }
}
