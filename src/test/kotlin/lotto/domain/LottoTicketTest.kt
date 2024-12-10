package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class LottoTicketTest : DescribeSpec({
    describe("방어적 복사 테스트") {
        it("should not same instance") {
            val lottos =
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                )

            val lottoTicket = LottoTicket(lottos)

            lottos shouldNotBeSameInstanceAs lottoTicket.tickets
        }
    }
})
