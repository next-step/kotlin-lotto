package lotto.domain.order

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.LotteryAdaptor
import lotto.domain.PurchasedLotteries
import lotto.mockLottery
import lotto.model.LottoErrorCode

class PurchaseOrderTest : StringSpec({

    "금액과 수동 로또 리스트를 가지고 구매 주문 객체를 만들 수 있고, 남은 금액만큼 자동 복권을 발급받는다." {
        val mockFirstLottery = mockLottery(1, 2, 3, 4, 5, 6)
        val mockSecondLottery = mockLottery(5, 2, 43, 24, 15, 6)
        val mockThirdLottery = mockLottery(1, 42, 33, 4, 15, 6)

        forAll(
            row(10000, emptyList(), (10000 / LotteryAdaptor.LOTTERY_PRICE).toInt()),
            row(25151, listOf(mockFirstLottery, mockSecondLottery), (25151 / LotteryAdaptor.LOTTERY_PRICE).toInt()),
            row(3132131, listOf(mockThirdLottery), (3132131 / LotteryAdaptor.LOTTERY_PRICE).toInt()),
            row(32234, listOf(mockFirstLottery), (32234 / LotteryAdaptor.LOTTERY_PRICE).toInt()),
            row(4534523, emptyList(), (4534523 / LotteryAdaptor.LOTTERY_PRICE).toInt()),
            row(12, emptyList(), (12 / LotteryAdaptor.LOTTERY_PRICE).toInt()),
            row(
                23344,
                listOf(mockFirstLottery, mockSecondLottery, mockThirdLottery),
                (23344 / LotteryAdaptor.LOTTERY_PRICE).toInt()
            ),
        ) { amount, manualLotteries, expect ->
            val purchaseOrder = PurchaseOrder(
                amount = amount,
                purchasedManualLotteries = PurchasedLotteries(lotteries = manualLotteries),
            )

            val manualLotterySize = manualLotteries.size

            purchaseOrder.purchasedAutoLotteries shouldHaveSize expect - manualLotterySize
            purchaseOrder.purchasedManualLotteries shouldHaveSize manualLotterySize
        }
    }

    "구매 주문을 생성할 때 문자열로도 요청할 수 있으며, 수동 로또를 생성하고 남은 돈 전부 자동 로또로 만든다." {
        val amountText = "10000"
        val manualLotteryTexts = listOf("1,2,3,4,5,6", "1,2,3,4,7,6")

        val purchaseOrder = PurchaseOrder(amountText = amountText, manualLotteryTexts)

        val maximumPurchaseQuantity = (amountText.toInt() / LotteryAdaptor.LOTTERY_PRICE).toInt()
        val manualLotterySize = manualLotteryTexts.size

        purchaseOrder.purchasedAutoLotteries shouldHaveSize maximumPurchaseQuantity - manualLotterySize
        purchaseOrder.purchasedManualLotteries shouldHaveSize manualLotterySize
    }

    "구매 주문을 생성할 때 숫자가 아닌 문자열과 2,147,483,647보다 큰 숫자를 입력하면 NumberFormatException 에러가 발생한다." {
        val manualLotteryTexts = listOf("1,2,3,4,5,6")

        forAll(
            row("  "),
            row("test"),
            row("한글이 아닙니다."),
            row("10000000000000"),
        ) { amountText ->
            shouldThrow<NumberFormatException> {
                PurchaseOrder(amountText = amountText, manualLotteryTexts = manualLotteryTexts)
            }
        }
    }

    "구매 주문을 생성할 때 총액보다 생성 요청한 수동 로또가 더 많은 경우 생성할 수 없다는 에러가 발생한다." {
        val amount = LotteryAdaptor.LOTTERY_PRICE.toInt()

        val purchasedLotteries = PurchasedLotteries(
            lotteries = listOf(
                mockLottery(1, 2, 3, 4, 5, 6),
                mockLottery(1, 22, 3, 4, 5, 6),
            ),
        )

        val exception = shouldThrow<IllegalStateException> {
            PurchaseOrder(amount = amount, purchasedManualLotteries = purchasedLotteries)
        }

        exception shouldHaveMessage LottoErrorCode.UNAVAILABLE_TO_PURCHASE.message("$amount ${purchasedLotteries.size}")
    }
})
