package lotto.controller

import lotto.domain.LotteryShop
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getMoney()
    val lottoCount = LotteryShop.buy(money)
    ResultView.printLottoCounts(lottoCount)

    val tickets = LotteryShop.getTickets(lottoCount)
}