package step2Lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import step2Lotto.domain.Lotto
import step2Lotto.domain.LottoRank
import step2Lotto.domain.LottoService
import step2Lotto.domain.WinningNumber
import step2Lotto.domain.dto.ProfitRateRequest
import step2Lotto.domain.dto.StatisticsRequest

class LottoServiceTest {
    private val lottoService = LottoService()

    @Test
    fun `로또 통계 계산`() {
        val lottoTickets = listOf(
            Lotto(arrayOf(11, 12, 13, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
        )

        val winningNumber = WinningNumber(arrayOf(1, 2, 3, 4, 5, 6))

        val req = StatisticsRequest(lottoTickets, winningNumber)
        val statistics = lottoService.getStatistics(req)

        statistics.count { it == LottoRank.FIRST } shouldBe 1
        statistics.count { it == LottoRank.THIRD } shouldBe 1
        statistics.count { it == LottoRank.FOURTH } shouldBe 1
        statistics.count { it == LottoRank.FIFTH } shouldBe 2
    }

    @Test
    fun `로또 수익률 계산`() {
        val purchaseAmount = 14000

        val statistics = listOf(
            LottoRank.FIFTH
        )

        lottoService.getProfitRate(ProfitRateRequest(purchaseAmount, statistics)) shouldBe 0.36
    }
}
