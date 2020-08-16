package lotto

import lotto.view.Input.inputBonusNumber
import lotto.view.Input.inputManualCount
import lotto.view.Input.inputManualNumbers
import lotto.view.Input.inputMoney
import lotto.view.Input.inputWinningLotto
import lotto.view.Output.printLottoTicket
import lotto.view.Output.printResult

const val LOTTO_PRICE = 1000

fun main() {
    val totalCount = inputMoney() / LOTTO_PRICE
    val manualCount = inputManualCount()
    val lottoTicket = inputManualNumbers(manualCount)
    repeat(totalCount - manualCount) {
        lottoTicket.createRandomLotto()
    }
    printLottoTicket(manualCount, totalCount - manualCount, lottoTicket)
    val winningLotto = inputWinningLotto()
    val bonusNumber = inputBonusNumber(winningLotto)
    printResult(lottoTicket.gameResult(winningLotto, bonusNumber))
}
