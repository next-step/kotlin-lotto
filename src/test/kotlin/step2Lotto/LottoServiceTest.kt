package step2Lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import step2Lotto.domain.Lotto
import step2Lotto.domain.LottoRank
import step2Lotto.domain.LottoService
import step2Lotto.domain.dto.StatisticsRequest

class LottoServiceTest {
    private val lottoService = LottoService(FixedLottoGenerator())

    @Test
    fun `구매 금액에 따른 로또를 몇장 구매할 수 있는지 계산한다`() {
        val purchaseAmount = 5000
        lottoService.getLottoTicketQuantity(purchaseAmount) shouldBe 5
    }

    @Test
    fun `구입 금액에 맞는 로또를 자동으로 구매한다`() {
        val lottoTicketQuantity = 5

        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )

        lottoService.purchaseLottoTickets(lottoTicketQuantity) shouldBe lottoTickets
    }

    @Test
    fun `로또 통계 계산`() {
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 14, 15, 16)),
            Lotto(listOf(1, 2, 3, 14, 15, 16)),
            Lotto(listOf(1, 2, 3, 4, 15, 16)),
            Lotto(listOf(1, 2, 3, 4, 5, 16)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )

        val winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val req = StatisticsRequest(lottoTickets, winningNumber)
        val statistics = lottoService.getStatistics(req).lottoStatistics

        statistics.count { it == LottoRank.FIRST } shouldBe 1
        statistics.count { it == LottoRank.THIRD } shouldBe 1
        statistics.count { it == LottoRank.FOURTH } shouldBe 1
        statistics.count { it == LottoRank.FIFTH } shouldBe 2
    }
}
