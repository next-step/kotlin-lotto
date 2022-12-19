package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StoreTest : DescribeSpec({
    describe("로또 판매기 테스트") {
        it("1000단위로 결제한 금액에 대한 로또 티켓의 갯수를 리턴할 수 있다.") {
            val purchasePrice = 14000

            Store.purchase(purchasePrice) shouldBe 14
        }

        it("결제한 금액이 1000원 단위가 아닐 경우 IllegalArgumentException을 throw한다.") {
            val purchasePrice = 14500

            shouldThrow<IllegalArgumentException> {
                Store.purchase(purchasePrice) shouldBe 14
            }
        }
    }
})
