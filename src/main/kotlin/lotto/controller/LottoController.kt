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
    val lottoCount = getLottoCount(money)
    val lottoTickets = getLottoTickets(lottoCount)
    val winningNumbers = getWinningNumbers()
    val result = lottoTickets.matchWith(winningNumbers)
    printResult(result)
    printProfit(result.calculateProfit(money))
}

fun getMoney(): Money = Money.makeForBuyingLotto(getPurchaseAmount())

fun getLottoCount(money: Money): Int = money.let {
    val lottoCount = it.convertToLottoTicketCount()
    printHowManyPurchase(lottoCount)
    lottoCount
}

fun getLottoTickets(count: Int): LottoTickets = LottoTickets.make(count).apply {
    printLottoTickets(this)
}
