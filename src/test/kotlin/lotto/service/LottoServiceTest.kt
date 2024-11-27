package lotto.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BonusNumber
import lotto.domain.LottoPurchasingMachine
import lotto.domain.LottoRank
import java.math.BigDecimal

class LottoServiceTest : StringSpec({
    val lottoPurchasingMachineService = LottoService(LottoPurchasingMachine(14000))
    val totalTicketCount = 14
    val manualTicketCount = 4

    "구매한 개수 중에 수동으로 구매한 수량을 제외한 나머지 수량만큼 자동으로 로또를 생성한다." {
        val lottoList = lottoPurchasingMachineService.lottoIssuance(totalTicketCount, manualTicketCount).map { it.lottoNumbers }
        lottoList.size shouldBe 10
    }

    "수익률을 계산해야 한다. (당첨 금액 / 구매 금액 의 소수점 둘째자리까지 버림)" {
        val fixedWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val fixedBonusNumber = BonusNumber(7)

        val lottoTickets = lottoPurchasingMachineService.lottoIssuance(
            totalTicketCount,
            manualTicketCount,
        )
        val totalPrize = lottoTickets.sumOf { ticket ->
            val matchCount = ticket.matchCount(fixedWinningNumbers)
            val hasBonusNumber = ticket.hasBonusNumber(fixedBonusNumber)
            LottoRank.from(matchCount, hasBonusNumber).prize
        }

        val profitRate = lottoPurchasingMachineService.calculateProfitRate(totalPrize)
        val expectedProfitRate = BigDecimal("0.00")

        profitRate shouldBe expectedProfitRate
    }
})