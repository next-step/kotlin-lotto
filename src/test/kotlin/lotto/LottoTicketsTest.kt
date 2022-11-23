package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTickets

internal class LottoTicketsTest : StringSpec({
    "정상적으로 로또 티켓들을 생성할 수 있다." {
        val lottoTickets = LottoTickets(5)
        lottoTickets.tickets.size shouldBe 5
    }
})
