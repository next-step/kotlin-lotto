package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PurchasePriceTest : FunSpec({
    test("구매 금액이 0원일 경우 정상 동작 테스트") {
        val purchasePrice = PurchasePrice(1000) - PurchasePrice(1000)

        purchasePrice.purchasePrice shouldBe 0
    }

    test("구매 금액이 음수가 되는 연산을 시도할 경우 IllegalArgumentException 예외 발생 테스트") {
        val purchasePrice = PurchasePrice(1000)

        shouldThrow<IllegalArgumentException> {
            purchasePrice - 2000
        }
    }

    test("구매 금액 대소 비교 정상 동작 테스트") {
        forAll(
            row(0, 0, false, false, true, true),
            row(0, 1, true, false, true, false),
            row(1, 0, false, true, false, true),
        ) { price1, price2, answer1, answer2, answer3, answer4 ->
            (PurchasePrice(price1) < PurchasePrice(price2)) shouldBe answer1
            (PurchasePrice(price1) > PurchasePrice(price2)) shouldBe answer2
            (PurchasePrice(price1) <= PurchasePrice(price2)) shouldBe answer3
            (PurchasePrice(price1) >= PurchasePrice(price2)) shouldBe answer4
        }
    }
})
