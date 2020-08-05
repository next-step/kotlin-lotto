package lotto

import lotto.domain.LottoLines
import lotto.view.inputBonusNumber
import lotto.view.inputMoney
import lotto.view.inputResult
import lotto.view.printLottoTicket
import lotto.view.printResult

const val LINE_PRICE = 1000

fun main() {
    val money = inputMoney()
    val lottoLines = LottoLines(money / LINE_PRICE)
    printLottoTicket(lottoLines.getLines())
    val result = inputResult()
    val bonusNumber = inputBonusNumber(result)
    lottoLines.checkResult(result, bonusNumber)
    printResult(lottoLines.getLines())
}
