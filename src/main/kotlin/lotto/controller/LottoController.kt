package lotto.controller

import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.view.getPurchaseAmount
import lotto.view.getWinningNumbers
import lotto.view.printHowManyPurchase
import lotto.view.printLottoTickets
import lotto.view.printProfit
import lotto.view.printResult

fun start() {
    val money = getMoney()
    val count = getLottoCount(money)
    val lottoTickets = getLottoTickets(count)
    val winningNumbers = getWinningNumbers()
    val result = lottoTickets.matchWith(winningNumbers)
    printResult(result)
    printProfit(result.calculateProfit(money))
}

fun getMoney(): Money = Money.make(getPurchaseAmount())

fun getLottoCount(money: Money): Int = money.convertToLottoTicketCount().apply {
    printHowManyPurchase(this)
}

fun getLottoTickets(count: Int): LottoTickets = LottoTickets(count).apply {
    printLottoTickets(this)
}
