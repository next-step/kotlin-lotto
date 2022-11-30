package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSaleMachineTest : DescribeSpec ({
    describe("로또 판매기 테스트") {
        it("결제한 금액에 대한 로또 티켓의 갯수를 리턴할 수 있다.") {
            val purchasePrice = 14500

            LottoSaleMachine.purchase(purchasePrice) shouldBe 14
        }
    }
})