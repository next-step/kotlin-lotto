package lotto.controller

import lotto.domain.LotteryShop
import lotto.domain.LottoNumber
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
    val bonusNum = LottoNumber(InputView.getBonusNum())
    val winningTicket = WinningTicket(lastLottoNums, bonusNum)
    val score = tickets.score(winningTicket)
    val rate = score.calculateRateOfReturn(money)
    ResultView.printResult(score, rate)
}
