package lotto.domain.order

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.Lottery
import lotto.model.LottoErrorCode

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

    "구매 주문을 생성할 때 문자열로도 생성할 수 있다." {
        val expect = "10000"
        val purchaseOrder = PurchaseOrder(amountText = expect)

        purchaseOrder.purchasedPrice shouldBe PurchaseOrder(amount = expect.toInt()).purchasedPrice
    }

    "구매 주문을 생성할 때 숫자가 아닌 문자열과 2,147,483,647보다 큰 숫자를 입력하면 구매할 수 없다는 에러가 발생한다." {
        forAll(
            row("  "),
            row("test"),
            row("한글이 아닙니다."),
            row("10000000000000"),
        ) { amountText ->
            val exception = shouldThrow<IllegalArgumentException> {
                PurchaseOrder(amountText = amountText)
            }

            exception shouldHaveMessage LottoErrorCode.INVALID_PURCHASE_AMOUNT.message(amountText)
        }
    }
})
