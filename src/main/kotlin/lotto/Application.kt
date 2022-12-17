package lotto

import lotto.domain.WinningNumber
import lotto.service.LottoPurchaseService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val payment = InputView.readPayment()
    val lottos = LottoPurchaseService.purchase(payment)

    OutputView.writeLottos(lottos)

    val winningNumber = WinningNumber(
        numbers = InputView.readWinningNumber(),
        bonusBall = InputView.readBonusBall()
    )
    val lottoResult = winningNumber.match(lottos)

    OutputView.writeResult(lottoResult.countByRank(), lottoResult.profit(payment))
}
