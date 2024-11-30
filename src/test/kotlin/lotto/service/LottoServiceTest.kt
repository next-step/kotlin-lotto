package lotto.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BonusNumber
import lotto.domain.LottoPurchasingMachine
import lotto.domain.LottoRank
import java.math.BigDecimal

class LottoServiceTest : StringSpec({
    val lottoPurchasingMachineService = LottoService(LottoPurchasingMachine(1000))

    "구매한 개수 중에 수동으로 구매한 수량을 제외한 나머지 수량만큼 자동으로 로또를 생성한다." {
        val lottoList = lottoPurchasingMachineService.lottoIssuance(14, 10).map { it.lottoNumbers }
        lottoList.size shouldBe 4
    }

    "수익률을 계산해야 한다. (수익이 나지 않는 경우)" {
        val fixedWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val fixedBonusNumber = BonusNumber(7)

        val lottoTickets =
            lottoPurchasingMachineService.lottoIssuance(
                1,
                1,
            )

        val totalPrize =
            lottoTickets.sumOf { ticket ->
                val matchCount = ticket.matchCount(fixedWinningNumbers)
                val hasBonusNumber = ticket.hasBonusNumber(fixedBonusNumber)
                LottoRank.from(matchCount, hasBonusNumber).prize
            }

        val profitRate = lottoPurchasingMachineService.calculateProfitRate(totalPrize)
        val expectedProfitRate = BigDecimal("0.00")

        profitRate shouldBe expectedProfitRate
    }

    "수익률을 계산해야 한다. (수익이 나는 경우)" {
        val lottoTickets = lottoPurchasingMachineService.lottoIssuance(1000, 10)
        val totalPrize =
            lottoTickets.sumOf { ticket ->
                val fixedWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
                val fixedBonusNumber = BonusNumber(7)
                val matchCount = ticket.matchCount(fixedWinningNumbers)
                val hasBonusNumber = ticket.hasBonusNumber(fixedBonusNumber)
                LottoRank.from(matchCount, hasBonusNumber).prize
            }

        val profitRate = lottoPurchasingMachineService.calculateProfitRate(totalPrize)

        profitRate.compareTo(BigDecimal.ZERO) shouldBe 1
    }
})
