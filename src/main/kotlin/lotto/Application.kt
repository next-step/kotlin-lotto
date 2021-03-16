package lotto

import lotto.domain.LottoCompany
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = InputView.inputPrice()

    val lottos = LottoStore().buy(money)
    OutputView.showPurchaseStatus(lottos)

    val winnerLottoNumber = InputView.inputWinnerNumber()
    val comp = LottoCompany()
    comp.setWinnerNumber(winnerLottoNumber)

    val winners = comp.findWinners(lottos)
    OutputView.showWinningStatus(winners)

    val earningRate = comp.calculateEarningRate(winners, money)
    OutputView.showEarningRatio(earningRate)
}
