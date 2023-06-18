package lotto.controller

import lotto.domain.Bank
import lotto.domain.LotteryShop
import lotto.domain.WinningTicket
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getMoney()
    val lottoCount = LotteryShop.buy(money)
    ResultView.printLottoCounts(lottoCount)

    val tickets = LotteryShop.getTickets(lottoCount)
    ResultView.printLottoNums(tickets)

    val score = Bank.score(tickets, WinningTicket(InputView.getLastLottoNums()))
    val rate = Bank.calculateRateOfReturn(money, score)
}
