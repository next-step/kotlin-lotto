package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.WinningNumber
import lotto.service.LottoPurchaseService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val payment = InputView.readPayment()
    val lottos = LottoPurchaseService.purchase(payment)
    OutputView.writeLottos(lottos.map { lotto -> lotto.numbers.map { it.value } })
    val winningNumber = WinningNumber(InputView.readWinningNumber().map { LottoNumber(it) }.toSet())
    val lottoResult = LottoResult(lottos, winningNumber)
    OutputView.writeResult(lottoResult.countByLottoMatch(), lottoResult.profit(payment))
}
