package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPurchaseOrderTest : StringSpec({
    "lotto purchase order should calculate correct total price and remainder" {
        val lottoPurchaseOrder = LottoPurchaseOrder(
            budget = 1200,
            ticketPrice = 1000,
            ticketCount = 1,
        )

        lottoPurchaseOrder.totalPrice shouldBe 1000
        lottoPurchaseOrder.remainder shouldBe 200

        val lottoPurchaseOrder2 = LottoPurchaseOrder(
            budget = 1200,
            ticketPrice = 1000,
            ticketCount = 0,
        )

        lottoPurchaseOrder2.totalPrice shouldBe 0
        lottoPurchaseOrder2.remainder shouldBe 1200
    }
})
