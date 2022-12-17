package lotto
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketBundleTest : FunSpec({
    context("여러 개의 로또 티켓 당첨 비교") {
        test("여러 개의 로또 티켓을 당첨 번호와 비교할 수 있다.") {
            val winningNumber = WinningNumber.from(numbers = listOf(5, 10, 15, 25, 35, 45))
            val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))
            val tickets = listOf(
                LottoTicket.purchase(1000, lottoNumber),
                LottoTicket.purchase(1000, lottoNumber),
                LottoTicket.purchase(1000, lottoNumber),
            )
            val lottoTicketBundle = LottoTicketBundle(tickets = tickets)
            val actual = lottoTicketBundle.match(winningNumber = winningNumber)
            actual.forEach { ticket ->
                ticket.status shouldBe LottoTicketStatus.WIN
                ticket.matchCount shouldBe 4
            }
        }
    }

})
