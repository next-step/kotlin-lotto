package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class LottoTicketTest : StringSpec({
    "로또 1장을 만들 수 있다." {
        LottoTicket() shouldNotBe null
        LottoTicket().numbers.size shouldBe 6
    }
})
