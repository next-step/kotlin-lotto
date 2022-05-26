package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.view.Input
import lotto.view.InputView

class InputViewTest : DescribeSpec({
    describe("askPurchaseAmount") {
        it("로또를 구매할 금액을 받아온다.") {
            val purchaseAmount = 14000
            val inputView = InputView(StubInput(purchaseAmount, listOf(1)))

            val expectPrice = inputView.askPurchaseAmount()

            expectPrice shouldBe purchaseAmount
        }
    }

    describe("askLastWeekWinningNumber") {
        it("지난 주 당첨 번호를 받아온다.") {
            val lastWeekWinningNumber = listOf(1, 2, 3, 4, 5, 6)
            val inputView = InputView(StubInput(14000, lastWeekWinningNumber))

            val expectPrice = inputView.askLastWeekWinningNumber()

            expectPrice shouldBe lastWeekWinningNumber
        }
    }
})

class StubInput(private val purchaseAmount: Int, private val numbers: List<Int>) : Input {
    override fun readPurchaseAmount(): Int = purchaseAmount

    override fun readLastWeekWinningNumbers(): List<Int> = numbers
}
