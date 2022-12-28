package com.nextstep.lotto

import com.nextstep.lotto.domain.LottoMachine
import com.nextstep.lotto.domain.WinningLotto
import com.nextstep.lotto.view.InputView
import com.nextstep.lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val inputAmount = inputView.inputAmount()
    val lottoMachine = LottoMachine()
    val lottoTickets = lottoMachine.purchase(inputAmount)

    outputView.printLottoTicketCount(lottoTickets.getCount(), lottoTickets)

    val winningNumbers = inputView.inputWinningNumbers()
    val winningLotto = WinningLotto(*winningNumbers)

    val lottoStat = lottoTickets.match(winningLotto)

    outputView.printResult(lottoStat)
}
