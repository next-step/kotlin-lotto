package lotto.controller

import lotto.domain.LotteryShop
import lotto.domain.WinningTicket
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getMoney()
    val lottoCount = LotteryShop.buy(money)
    val manualNum = InputView.getManualLotto()
    LotteryShop.validateManualNum(manualNum, lottoCount)
    val manualLottos = InputView.getManualLotto(manualNum)
    val tickets = LotteryShop.getTickets(lottoCount, manualLottos)
    ResultView.printLottos(manualNum, tickets)

    val lastLottoNums = InputView.getWinningLottoNums()
    val bonusNum = InputView.getBonusNum()
    val winningTicket = WinningTicket(lastLottoNums, bonusNum)
    val score = winningTicket.score(tickets)
    val rate = LotteryShop.calculateRateOfReturn(money, score)
    ResultView.printResult(score, rate)
}
