package lotto.controller

import lotto.domain.Bank
import lotto.domain.LotteryShop
import lotto.domain.Lotto
import lotto.domain.WinningTicket
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getMoney()
    val lottoCount = LotteryShop.buy(money)
    ResultView.printLottoCounts(lottoCount)

    val tickets = LotteryShop.getTickets(lottoCount)
    ResultView.printLottoNums(tickets)

    val lastLottoNums = Lotto(InputView.getLastLottoNums())
    val bonusNum = InputView.getBonusNum()
    val score = Bank.score(tickets, WinningTicket(lastLottoNums, bonusNum))
    val rate = Bank.calculateRateOfReturn(money, score)
    ResultView.printResult(score, rate)
}
