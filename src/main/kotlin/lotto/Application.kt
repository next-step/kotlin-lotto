package lotto

import lotto.service.LottoPurchaseService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val payment = InputView.readPayment()
    val lottos = LottoPurchaseService.purchase(payment)

    OutputView.writeLottos(lottos)

    val winningNumber = InputView.readWinningNumber()
    val lottoResult = winningNumber.match(lottos)

    OutputView.writeResult(lottoResult.countByRank(), lottoResult.profit(payment))
}
