package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PurchasePriceTest : FunSpec({
    test("구매 금액이 0원일 경우 정상 동작 테스트") {
        val purchasePrice = PurchasePrice(1000) - PurchasePrice(1000)

        purchasePrice.purchasePrice shouldBe  0
    }

    test("구매 금액이 음수가 되는 연산을 시도할 경우 IllegalArgumentException 예외 발생 테스트") {
        val purchasePrice = PurchasePrice(1000)

        shouldThrow<IllegalArgumentException> {
            purchasePrice - 2000
        }
    }
})
