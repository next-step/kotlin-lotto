package lotto.domain.result

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Money
import lotto.domain.test.lottery
import lotto.domain.test.lotteryTicket

class LotteryPurchaseResultsTest : StringSpec({
    "로또 티켓을 얻는다" {
        // given
        val manualLotteryTicket = lotteryTicket(
            lottery(1, 2, 3, 4, 5, 6),
            lottery(7, 8, 9, 10, 11, 12)
        )
        val manualLotteryPurchaseResult = ManualLotteryPurchaseResult(manualLotteryTicket, change = Money(2_000))

        val autoLotteryTicket = lotteryTicket(
            lottery(13, 14, 15, 16, 17, 18),
            lottery(19, 20, 21, 22, 23, 24)
        )
        val autoLotteryPurchaseResult = AutoLotteryPurchaseResult(autoLotteryTicket, change = Money(2_000))

        val results = LotteryPurchaseResults(listOf(manualLotteryPurchaseResult, autoLotteryPurchaseResult))

        // when
        val lotteryTicket = results.getLotteryTicket()

        // result
        lotteryTicket shouldBe lotteryTicket(
            lottery(1, 2, 3, 4, 5, 6),
            lottery(7, 8, 9, 10, 11, 12),
            lottery(13, 14, 15, 16, 17, 18),
            lottery(19, 20, 21, 22, 23, 24)
        )
    }

    "구매 타입 별로 구분한다" {
        // given
        val manualLotteryTicket = lotteryTicket(
            lottery(1, 2, 3, 4, 5, 6),
            lottery(7, 8, 9, 10, 11, 12)
        )
        val manualLotteryPurchaseResult = ManualLotteryPurchaseResult(manualLotteryTicket, change = Money(2_000))

        val autoLotteryTicket = lotteryTicket(
            lottery(13, 14, 15, 16, 17, 18),
            lottery(19, 20, 21, 22, 23, 24)
        )
        val autoLotteryPurchaseResult = AutoLotteryPurchaseResult(autoLotteryTicket, change = Money(2_000))

        val givenResults = LotteryPurchaseResults(listOf(manualLotteryPurchaseResult, autoLotteryPurchaseResult))

        // when
        val result = givenResults.seperatedByPurchaseType()

        // then
        result[PurchaseType.MANUAL] shouldBe manualLotteryPurchaseResult
        result[PurchaseType.AUTO] shouldBe autoLotteryPurchaseResult
    }
})
