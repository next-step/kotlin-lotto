package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class ProfitAnalyzerTest : StringSpec({
    "당첨 통계를 구한다(1등 1개, 2등 1개, 3등 2개, 4등 2개)" {
        // given
        val winnerLottery = Lottery(setOf(4, 5, 6, 7, 8, 9))

        val lotteryTicket = LotteryTicket(
            listOf(
                Lottery(setOf(1, 2, 3, 4, 5, 6)), // 4등
                Lottery(setOf(1, 2, 3, 4, 5, 6)), // 4등
                Lottery(setOf(1, 2, 4, 5, 6, 7)), // 3등
                Lottery(setOf(1, 2, 4, 5, 6, 7)), // 3등
                Lottery(setOf(1, 4, 5, 6, 7, 8)), // 2등
                Lottery(setOf(4, 5, 6, 7, 8, 9)), // 1등
                Lottery(setOf(10, 11, 12, 13, 14, 15)), // 해당 없음
            )
        )
        val expect = PrizeStatics(
            mapOf(
                WinnerPrize.FIRST_PRIZE to 1,
                WinnerPrize.SECOND_PRIZE to 1,
                WinnerPrize.THIRD_PRIZE to 2,
                WinnerPrize.FOURTH_PRIZE to 2,
                WinnerPrize.NOTHING to 1
            )
        )
        // when
        val result = ProfitAnalyzer.getStaticsOnPrizeMoney(lotteryTicket, winnerLottery)
        // then
        result shouldBe expect
    }

    "수익률을 구한다" {
        val prizeStatics = PrizeStatics(
            mapOf(
                WinnerPrize.FOURTH_PRIZE to 3,
                WinnerPrize.NOTHING to 1
            )
        )

        val profitRate = ProfitAnalyzer.getProfitRate(prizeStatics, Money(20_000))

        profitRate shouldBe BigDecimal(0.75)
    }
})
