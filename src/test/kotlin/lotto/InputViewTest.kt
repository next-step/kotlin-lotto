package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : DescribeSpec({
    describe("askPrice") {
        it("로또를 구매할 금액을 받아온다.") {
            val purchaseAmount = 14000
            val inputView = InputView(StubInput(purchaseAmount))

            val expectPrice = inputView.askPurchaseAmount()

             expectPrice shouldBe purchaseAmount
        }
    }
})

class StubInput(private val purchaseAmount: Int): IInput {
    override fun readPurchaseAmount(): Int {
        return purchaseAmount
    }
}
