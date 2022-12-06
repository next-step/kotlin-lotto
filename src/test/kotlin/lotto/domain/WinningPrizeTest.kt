package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import lotto.domain.vo.PurchaseAmount

class WinningPrizeTest : FunSpec({
    context("find()") {
        test("일치하는 번호 개수, 보너스 번호 여부에 따른 당첨 결과를 반환한다.") {
            table(
                headers("matchedCount", "hasBonusNumber", "expectedResult"),
                row(6, true, WinningPrize.FIRST_PRIZE),
                row(6, false, WinningPrize.FIRST_PRIZE),
                row(5, true, WinningPrize.SECOND_PRIZE),
                row(5, false, WinningPrize.THIRD_PRIZE),
                row(4, true, WinningPrize.FOURTH_PRIZE),
                row(4, false, WinningPrize.FOURTH_PRIZE),
                row(3, true, WinningPrize.FIFTH_PRIZE),
                row(3, false, WinningPrize.FIFTH_PRIZE),
                row(2, true, WinningPrize.NONE),
                row(2, false, WinningPrize.NONE)
            ).forAll { matchedCount, hasBonusNumber, expectedResult ->
                WinningPrize.find(matchedCount, hasBonusNumber) shouldBe expectedResult
            }
        }
    }
    context("calculateRateOfReturn") {
        test("수익률을 반환한다.") {
            val purchaseAmount = PurchaseAmount(1000)

            table(
                headers("winningPrize", "rateOfReturn"),
                row(WinningPrize.FIRST_PRIZE, 2000000.0),
                row(WinningPrize.SECOND_PRIZE, 30000.0),
                row(WinningPrize.THIRD_PRIZE, 1500.0),
                row(WinningPrize.FOURTH_PRIZE, 50.0),
                row(WinningPrize.FIFTH_PRIZE, 5.0),
                row(WinningPrize.NONE, 0.0)
            ).forAll { winningPrize, rateOfReturn ->
                winningPrize.calculateRateOfReturn(purchaseAmount) shouldBe rateOfReturn
            }
        }
    }
})
