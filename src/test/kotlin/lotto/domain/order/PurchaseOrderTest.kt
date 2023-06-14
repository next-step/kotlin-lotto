package lotto.domain.order

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery

class PurchaseOrderTest : StringSpec({

    "금액을 가지고 구매 주문 객체를 만들 수 있고, 할당된 금액만큼 복권을 발급받는다." {
        forAll(
            row(10000, (10000 / Lottery.LOTTERY_PRICE).toInt()),
            row(25151, (25151 / Lottery.LOTTERY_PRICE).toInt()),
            row(3132131, (3132131 / Lottery.LOTTERY_PRICE).toInt()),
            row(32234, (32234 / Lottery.LOTTERY_PRICE).toInt()),
            row(4534523, (4534523 / Lottery.LOTTERY_PRICE).toInt()),
            row(23344, (23344 / Lottery.LOTTERY_PRICE).toInt()),
            row(12, (12 / Lottery.LOTTERY_PRICE).toInt()),
        ) { amount, expect ->
            val purchaseOrder = PurchaseOrder(amount = amount)

            purchaseOrder.purchasedLotteries.size shouldBe expect
        }
    }

    "구매 주문을 생성할 때 문자열로도 생성할 수 있으며, amount로 생성한 로또와 동일한 개수를 가진다." {
        val expect = "10000"
        val purchaseOrder = PurchaseOrder(amountText = expect)

        purchaseOrder.purchasedLotteries.size shouldBe PurchaseOrder(amount = expect.toInt()).purchasedLotteries.size
    }

    "구매 주문을 생성할 때 숫자가 아닌 문자열과 2,147,483,647보다 큰 숫자를 입력하면 NumberFormatException 에러가 발생한다." {
        forAll(
            row("  "),
            row("test"),
            row("한글이 아닙니다."),
            row("10000000000000"),
        ) { amountText ->
            shouldThrow<NumberFormatException> {
                PurchaseOrder(amountText = amountText)
            }
        }
    }
})
