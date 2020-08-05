package lotto

import lotto.domain.LottoLines
import lotto.view.inputBonusNumber
import lotto.view.inputManualCount
import lotto.view.inputManualNumbers
import lotto.view.inputMoney
import lotto.view.inputResult
import lotto.view.printLottoTicket
import lotto.view.printResult

const val LINE_PRICE = 1000
const val LOTTO_NUMBERS_COUNT = 6

fun main() {
    val money = inputMoney()
    val manualCount = inputManualCount()
    val lottoLines = LottoLines(money / LINE_PRICE, inputManualNumbers(manualCount))
    printLottoTicket(lottoLines.getLines())
    val result = inputResult()
    val bonusNumber = inputBonusNumber(result)
    lottoLines.checkResult(result, bonusNumber)
    printResult(lottoLines.getLines())
}
