package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoStatisticService
import lotto.domain.PurchaseAmount
import lotto.domain.WinningLotto
import lotto.domain.dto.ProfitRateRequest
import lotto.domain.dto.StatisticsRequest
import org.junit.jupiter.api.Test

class LottoStatisticServiceTest {
    private val lottoStatisticService = LottoStatisticService()

    @Test
    fun `구매한 로또와 당첨 번호가 주어지면 각 로또의 등수를 확인할 수 있다`() {
        val lottoTickets = listOf(
            Lotto(arrayOf(11, 12, 13, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 14, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 15, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 16)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
        )

        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }, LottoNumber(10))

        val req = StatisticsRequest(lottoTickets, winningLotto)
        val statistics = lottoStatisticService.getStatistics(req)

        statistics.count { it == LottoRank.FIRST } shouldBe 1
        statistics.count { it == LottoRank.THIRD } shouldBe 1
        statistics.count { it == LottoRank.FOURTH } shouldBe 1
        statistics.count { it == LottoRank.FIFTH } shouldBe 2
    }

    @Test
    fun `구매 금액과 당첨 결과가 주어지면 수익률을 계산할다`() {
        val purchaseAmount = PurchaseAmount(14000)

        val statistics = listOf(
            LottoRank.FIFTH
        )

        lottoStatisticService.getProfitRate(ProfitRateRequest(purchaseAmount, statistics)) shouldBe 0.36
    }
}
