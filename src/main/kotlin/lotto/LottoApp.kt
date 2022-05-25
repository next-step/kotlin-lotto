package lotto

import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val payment = inputView.readPayment()
    val receipt = Receipt(payment)

    resultView.buyCount(receipt.lottoCount)

    val lottoMachine = LottoMachine(receipt)
    val lottos = lottoMachine.issue()

    resultView.lottoNumbers(lottos)

    val lastNumber = inputView.readLastNumber()
    val statResults = lottoMachine.verify(lastNumber, lottos)

    resultView.result(statResults)

    val yields = lottoMachine.yields(statResults)

    resultView.yields(yields)
}
