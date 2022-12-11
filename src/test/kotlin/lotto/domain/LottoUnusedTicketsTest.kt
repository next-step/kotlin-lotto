package lotto.domain

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
    }
})
