package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.PurchaseAmount

class WinningPrizesTest : FunSpec({
    context("객체 생성") {
        test("당첨 상금 리스트를 받아 객체를 생성한다.") {
            shouldNotThrowAny {
                WinningPrizes(listOf(WinningPrize.FOURTH_PRIZE, WinningPrize.THIRD_PRIZE))
            }
        }
    }
    context("extractStatisticOfMatchedCount()") {
        test("당첨 번호 일치 개수의 통계를 추출한다.") {
            val winningPrizes = WinningPrizes(listOf(WinningPrize.FOURTH_PRIZE, WinningPrize.FOURTH_PRIZE, WinningPrize.THIRD_PRIZE))

            val actual = winningPrizes.extractStatisticOfMatchedCount()

            actual[WinningPrize.FOURTH_PRIZE.matchedCount] shouldBe 2
            actual[WinningPrize.THIRD_PRIZE.matchedCount] shouldBe 1
        }
    }
    context("calculateTotalRateOfReturn()") {
        test("구매 금액을 입력받아 총 수익률을 계산하여 반환한다.") {
            val purchaseAmount = PurchaseAmount(1000)
            val prizes = listOf(WinningPrize.FIRST_PRIZE, WinningPrize.SECOND_PRIZE, WinningPrize.THIRD_PRIZE, WinningPrize.FOURTH_PRIZE)
            val winningPrizes = WinningPrizes(prizes)

            val actual = winningPrizes.calculateTotalRateOfReturn(purchaseAmount)

            actual shouldBe 2001555.0
        }
    }
})
