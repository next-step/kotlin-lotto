package lotto

import lotto.domain.LottoResult
import lotto.service.LottoPurchaseService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val payment = InputView.readPayment()
    val lottos = LottoPurchaseService.purchase(payment)

    OutputView.writeLottos(lottos)

    val lottoResult = LottoResult(lottos, InputView.readWinningNumber())

    OutputView.writeResult(lottoResult.countByLottoMatch(), lottoResult.profit(payment))
}
