package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.ResultView

class LottoApp {
}

fun main() {
    val inputView = InputView()
    val count = inputView.inputUser()
    val tickets = LottoTicket.generateLottoTickets(count)
    println("${tickets.size}개를 구매했습니다.")
    println(tickets.joinToString (
        separator = "\n",
        prefix = "",
        postfix = ""
    ))

    val winNumbers = inputView.inputWinNumbers()
    val winTicket = LottoTicket(winNumbers)

    println(winTicket)

    val lottoResult = LottoResult(tickets, winTicket, count)

    val resultView = ResultView()
    resultView.printResult(lottoResult)
}