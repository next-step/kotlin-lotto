package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoTicketTest : StringSpec({
    "로또 1장을 만들 수 있다." {
        LottoTicket(LottoNumberSelector.select()).numbers.size shouldBe 6
    }
})
