package lotto

import lotto.domain.LottoMachine
import lotto.domain.Receipt
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val payment = inputView.readPayment()
    val receipt = Receipt(payment)
    val lottoMachine = LottoMachine(receipt)
    val lottoTickets = lottoMachine.issue()
    val lastLottoTicket = inputView.readLastNumber()
    val bonusNumber = inputView.readBonusNumber()
    val statResults = lottoMachine.verify(lastLottoTicket, bonusNumber, lottoTickets)
    val yields = lottoMachine.yields(statResults)

    resultView.result(receipt, lottoTickets, statResults, yields)
}
