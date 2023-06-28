package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import lotto.domain.*
import lotto.domain.dto.ProfitRateRequest
import lotto.domain.dto.StatisticsRequest

class LottoStatisticServiceTest {
    private val lottoStatisticService = LottoStatisticService()

    @Test
    fun `구매한 로또와 당첨 번호가 주어지면 1등부터 5등, 꽝을 계산한다`() {
        val lottoTickets = listOf(
            Lotto(arrayOf(11, 12, 13, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
        )

        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }, LottoNumber(5))

        val req = StatisticsRequest(lottoTickets, winningLotto)
        val statistics = lottoStatisticService.getStatistics(req)

        statistics.count { it == LottoRank.FIRST } shouldBe 1
        statistics.count { it == LottoRank.THIRD } shouldBe 1
        statistics.count { it == LottoRank.FOURTH } shouldBe 1
        statistics.count { it == LottoRank.FIFTH } shouldBe 2
    }

    @Test
    fun `구매 금액과 당첨 결과가 주어지면 수익률을 계산할다`() {
        val purchaseAmount = 14000

        val statistics = listOf(
            LottoRank.FIFTH
        )

        lottoStatisticService.getProfitRate(ProfitRateRequest(purchaseAmount, statistics)) shouldBe 0.36
    }
}
