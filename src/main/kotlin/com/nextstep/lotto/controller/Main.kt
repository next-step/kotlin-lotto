package com.nextstep.lotto.controller

import com.nextstep.lotto.domain.LottoNumber
import com.nextstep.lotto.domain.LottoSeller
import com.nextstep.lotto.domain.WinningNumber
import com.nextstep.lotto.view.InputView
import com.nextstep.lotto.view.OutputView

fun main() {
    OutputView.printPurchaseAmountInputMessage()

    val moneyInput = InputView.inputMessage()
    val lottoTickets = moneyInput.let { LottoSeller.sellLotto(it.toLong()) }

    OutputView.printLottoTicketMessage(lottoTickets.size())
    OutputView.printLottoTickets(lottoTickets)
    OutputView.printLastWeekWinningNumberMessage()

    val winningNumber =
        WinningNumber(InputView.inputMessageSplitWithComma().map { LottoNumber.from(it.toInt()) }.toSet())
    val result = lottoTickets.calculateResult(winningNumber)

    OutputView.printWinningStatMessage()
    OutputView.printResult(result)
    OutputView.printRatioResult(result.calculateRatio(moneyInput.toLong()))
}
