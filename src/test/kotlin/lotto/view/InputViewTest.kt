package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.view.Input
import lotto.view.InputView

class InputViewTest : DescribeSpec({
    describe("askPurchaseAmount") {
        it("로또를 구매할 금액을 받아온다.") {
            val purchaseAmount = 14000
            val inputView = InputView(StubInput(purchaseAmount, listOf(1), 1))

            val expectPrice = inputView.askPurchaseAmount()

            expectPrice shouldBe purchaseAmount
        }
    }

    describe("askLastWeekWinningNumber") {
        it("지난 주 당첨 번호를 받아온다.") {
            val lastWeekWinningNumber = listOf(1, 2, 3, 4, 5, 6)
            val inputView = InputView(StubInput(14000, lastWeekWinningNumber, 1))

            val expectPrice = inputView.askLastWeekWinningNumber()

            expectPrice shouldBe lastWeekWinningNumber
        }
    }

    describe("askBonusNumber") {
        it("보너스 볼을 받아온다.") {
            val bonusNumber = 1
            val inputView = InputView(StubInput(14000, listOf(1), bonusNumber))

            val expectPrice = inputView.askBonusNumber()

            expectPrice shouldBe bonusNumber
        }
    }
})

class StubInput(private val purchaseAmount: Int, private val numbers: List<Int>, private val number: Int) : Input {
    override fun readPurchaseAmount(): Int = purchaseAmount

    override fun readLastWeekWinningNumbers(): List<Int> = numbers

    override fun readBonusNumber(): Int = number
}
