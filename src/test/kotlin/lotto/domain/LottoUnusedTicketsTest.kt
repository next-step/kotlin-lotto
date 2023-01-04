package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoUnusedTickets
 */
class LottoUnusedTicketsTest : FeatureSpec({

    feature("LottoUnusedTickets") {
        scenario("from은 입력한 갯수만큼 미사용 티켓을 생성하여 반환한다.") {
            val ticketCount = 6
            val lottoUnusedTickets = LottoUnusedTickets.from(ticketCount)

            lottoUnusedTickets.getTicketCount() shouldBe ticketCount
        }

        scenario("divide는 입력한 숫자만큼 티켓을 분류해서 반환한다.") {
            val ticketCount = 6
            val lottoUnusedTickets = LottoUnusedTickets.from(ticketCount)
            val (ticketsA, ticketsB) = lottoUnusedTickets.divide(2)

            ticketsA.getTicketCount() shouldBe 2
            ticketsB.getTicketCount() shouldBe 4
        }

        scenario("티켓 수보다 많은 수의 티켓을 수동으로 입력하면 에러를 던진다.") {
            val ticketCount = 2
            val lottoUnusedTickets = LottoUnusedTickets.from(ticketCount)

            val manualTicketNumbers = listOf(
                "1,2,3,4,5,6",
                "7,8,9,10,11,12",
                "13,14,15,16,17"
            )

            shouldThrowExactly<IllegalArgumentException> {
                lottoUnusedTickets.toManual(manualTicketNumbers)
            }
        }
    }
})
