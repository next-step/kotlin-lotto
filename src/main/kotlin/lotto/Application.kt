package lotto

import lotto.domain.WinningNumber
import lotto.service.LottoPurchaseService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val payment = InputView.readPayment()
    val manualCount = InputView.readManualCount()
    val manualLottos = InputView.readManualLottos(manualCount)
    val lottos = LottoPurchaseService.purchase(payment, manualLottos)

    OutputView.writeLottos(manualCount, lottos)

    val winningNumber = WinningNumber(
        numbers = InputView.readWinningNumber(),
        bonusBall = InputView.readBonusBall()
    )
    val lottoResult = winningNumber.match(lottos)

    OutputView.writeResult(lottoResult.countByRank(), lottoResult.profit(payment))
}
