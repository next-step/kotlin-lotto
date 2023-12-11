package lotto.generator.ticket

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class ManualTicketGeneratorTest : BehaviorSpec({
    given("manual ticket generator") {
        `when`("creates lotto Tickets") {
            then("should provide correct tickets") {
                val ticketBlueprint1 = listOf(1, 2, 3, 4, 5, 6)
                val ticketBlueprint2 = listOf(3, 4, 5, 6, 7, 8)
                val ticketBlueprint3 = listOf(5, 6, 7, 8, 9, 13)

                val lottoTickets = ManualTicketGenerator.create(
                    listOf(
                        ticketBlueprint1,
                        ticketBlueprint2,
                        ticketBlueprint3,
                    )
                )
                lottoTickets.lottoTicketList.size shouldBe 3
                lottoTickets.lottoTicketList[0] shouldBe LottoTicket(ticketBlueprint1.map { LottoNumber(it) })
                lottoTickets.lottoTicketList[1] shouldBe LottoTicket(ticketBlueprint2.map { LottoNumber(it) })
                lottoTickets.lottoTicketList[2] shouldBe LottoTicket(ticketBlueprint3.map { LottoNumber(it) })
            }
        }
    }
})
