package view.console

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import view.OutputView

class ConsoleOutput : OutputView {
    override fun printStringAdderInputMessage() {
        println("덧셈할 숫자를 쉼표(,)와 콜론(:)으로 구분해서 입력해주세요.")
    }

    override fun printStringAdderResultMessage(result: Int) {
        println("결과는 ${result}입니다.")
    }

    override fun printPurchaseAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    override fun printLottoTickets(tickets: LottoTickets) {
        println("${tickets.tickets.size}개를 구매했습니다.")
        tickets.tickets.forEach { printLottoTicket(it) }
    }

    private fun printLottoTicket(ticket: LottoTicket) {
        println("[${ticket.numbers.sorted().joinToString(", ")}]")
    }
}
