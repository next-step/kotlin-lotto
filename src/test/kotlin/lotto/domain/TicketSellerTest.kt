package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.util.KotlinRandomGenerate

class TicketSellerTest : DescribeSpec({
    it("티켓 판매자는 금액으로 가능한 만큼 티켓을 구매할수 있다") {
        // given
        val ticketPrice = Money(1000)
        val ticketSeller = TicketSeller(KotlinRandomGenerate, ticketPrice)
        val userMoney = Money(20000)

        // when
        val boughtTickets = ticketSeller.buyPossibleLottoTicket(userMoney)

        // then
        boughtTickets.size shouldBe userMoney.value / ticketPrice.value
    }
})
