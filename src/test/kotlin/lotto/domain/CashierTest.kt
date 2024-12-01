package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class CashierTest : DescribeSpec({
    describe("입력한 금액만큼 로또를 구매한다") {
        it("1000원 보다 적은 경우 throw exception") {
            assertThrows<IllegalArgumentException> {
                Cashier.purchaseLotto(999)
            }
        }

        it("1000원 짜리 로또를 구매한다") {
            val actual = Cashier.purchaseLotto(3000)
            actual shouldBe 3
        }

        it("100원 단위는 내림처리 한다.") {
            val actual = Cashier.purchaseLotto(3500)
            actual shouldBe 3
        }
    }
})
