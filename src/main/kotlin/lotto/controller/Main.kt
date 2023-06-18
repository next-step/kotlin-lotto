package lotto.controller

import lotto.domain.LotteryShop
import lotto.view.InputView

fun main() {
    val money = InputView.getMoney()
    val lottoCount = LotteryShop.buy(money)
}