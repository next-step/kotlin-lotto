package lotto.domain.order

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
        ) { amount, expect ->
            val purchaseOrder = PurchaseOrder(amount = amount)

            purchaseOrder.purchasedLotteries.size shouldBe expect
        }
    }

    "구매한 복권 리스트의 총액을 알 수 있다." {
        forAll(
            row(10000, 10000 - (10000 % Lottery.LOTTERY_PRICE)),
            row(2342342, 2342342 - (2342342 % Lottery.LOTTERY_PRICE)),
            row(43435, 43435 - (43435 % Lottery.LOTTERY_PRICE)),
            row(453455, 453455 - (453455 % Lottery.LOTTERY_PRICE)),
        ) { amount, expect ->
            val purchaseOrder = PurchaseOrder(amount = amount)

            purchaseOrder.purchasedPrice shouldBe expect
        }
    }
})
