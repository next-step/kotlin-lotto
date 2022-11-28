package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LotteryTicketMachineTest : DescribeSpec ({
    describe("로또 발권기 테스트") {
        it("결제한 금액에 대한 로또 티켓의 갯수를 리턴할 수 있다.") {
            val purchasePrice = 14500

            LotteryTicketMachine.ticketing(purchasePrice) shouldBe 14
        }
    }
})