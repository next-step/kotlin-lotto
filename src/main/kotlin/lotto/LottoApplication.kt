package lotto

import lotto.ui.LottoController
import lotto.ui.view.getBonusLottoNumber
import lotto.ui.view.getManualLottoNumbers
import lotto.ui.view.getPurchasePrice
import lotto.ui.view.getWinningLottoNumbers
import lotto.ui.view.printLottoResult
import lotto.ui.view.printLottos
import lotto.ui.view.printTicketInfo

fun main() {
    val purchasePrice = getPurchasePrice()
    val lottoNumbersList = getManualLottoNumbers()

    val ticket = LottoController.purchaseTicket(purchasePrice, lottoNumbersList)
    val purchasedLottos = LottoController.issueLottos(ticket)
    printTicketInfo(ticket)
    printLottos(purchasedLottos)

    val winningLottoNumbers = getWinningLottoNumbers()
    val bonusLottoNumber = getBonusLottoNumber()
    val winningLotto = LottoController.drawWinningLottos(winningLottoNumbers, bonusLottoNumber)

    val roundResult = LottoController.getRoundResult(purchasedLottos, winningLotto)
    val earningRate = LottoController.calculateEarningRate(roundResult)
    printLottoResult(roundResult, earningRate)
}
