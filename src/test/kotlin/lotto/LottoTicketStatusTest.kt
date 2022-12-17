package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketStatusTest : FunSpec({
    context("로또 티켓 상태") {
        test("현재 당첨된 상태인지 알 수 있다.") {
            LottoTicketStatus.WIN.isWinStatus() shouldBe true
            LottoTicketStatus.NOT_WIN.isWinStatus() shouldBe false
            LottoTicketStatus.WAITING.isWinStatus() shouldBe false
        }

        test("맞춘 갯수로 로또 티켓 상태를 정할 수 있다.") {
            LottoTicketStatus.from(matchCount = 3) shouldBe LottoTicketStatus.WIN
            LottoTicketStatus.from(matchCount = 2) shouldBe LottoTicketStatus.NOT_WIN
        }
    }
})
