package lotto

import lotto.domain.AutoLottoSelector
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val payment = InputView.readPayment()
    val lottoCount = payment / 1000
    val lottos = (1..lottoCount)
        .map { AutoLottoSelector.select() }
    OutputView.writeLottos(lottos.map { lotto -> lotto.numbers.map { it.value } })
    val winningNumber = WinningNumber(InputView.readWinningNumber().map { LottoNumber(it) }.toSet())
    val lottoResult = LottoResult(lottos, winningNumber)
    OutputView.writeResult(lottoResult.countByLottoMatch(), lottoResult.profit(payment))
}
