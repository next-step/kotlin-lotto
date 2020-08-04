package lotto

import lotto.domain.LottoLines
import lotto.view.inputMoney
import lotto.view.inputResult
import lotto.view.printLottoTicket
import lotto.view.printResult

const val LINE_PRICE = 1000

fun main() {
    val money = inputMoney()
    val lottoTicket = LottoLines(money / LINE_PRICE)
    printLottoTicket(lottoTicket.getLines())
    val result = inputResult()
    printResult(lottoTicket.getLines())
}
