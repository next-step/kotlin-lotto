package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class LottoTicketBundleTest : StringSpec({
    "로또 n개를 만들 수 있다." {
        val lottoTicketCount = LottoTicketCount(5, 0)
        val lottoTicketBundle = LottoTicketBundle(lottoTicketCount)
        lottoTicketBundle shouldNotBe null
        lottoTicketBundle.lottoTickets.size shouldBe 5
    }
})
