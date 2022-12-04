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
        test("일치하는 번호 개수에 따른 당첨 결과를 반환한다.") {
            table(
                headers("matchedCount", "winningPrize"),
                row(6, WinningPrize.FIRST_PRIZE),
                row(5, WinningPrize.SECOND_PRIZE),
                row(4, WinningPrize.THIRD_PRIZE),
                row(3, WinningPrize.FOURTH_PRIZE),
                row(2, WinningPrize.NONE)
            ).forAll { matchedCount, winningPrize ->
                WinningPrize.find(matchedCount) shouldBe winningPrize
            }
        }
    }
    context("calculateRateOfReturn") {
        test("수익률을 반환한다.") {
            val purchaseAmount = PurchaseAmount(1000)

            table(
                headers("winningPrize", "rateOfReturn"),
                row(WinningPrize.FIRST_PRIZE, 2000000.0),
                row(WinningPrize.SECOND_PRIZE, 1500.0),
                row(WinningPrize.THIRD_PRIZE, 50.0),
                row(WinningPrize.FOURTH_PRIZE, 5.0),
                row(WinningPrize.NONE, 0.0)
            ).forAll { winningPrize, rateOfReturn ->
                winningPrize.calculateRateOfReturn(purchaseAmount) shouldBe rateOfReturn
            }
        }
    }
})
