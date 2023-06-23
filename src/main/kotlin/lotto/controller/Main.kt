package lotto.controller

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
    val winningTicket = WinningTicket(lastLottoNums, bonusNum)
    val score = winningTicket.score(tickets)
    val rate = winningTicket.calculateRateOfReturn(money, score)
    ResultView.printResult(score, rate)
}
