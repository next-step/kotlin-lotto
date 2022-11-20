package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class LottoTicketBundleTest : StringSpec({
    "로또 n장 묶음을 만들 수 있다." {
        val ticketSize = 5
        val lottoTicketBundle = LottoTicketBundle(ticketSize)
        lottoTicketBundle shouldNotBe null
        lottoTicketBundle.lottoTickets.size shouldBe ticketSize
    }
})
