package lotto.controller

import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.view.getBonusNumber
import lotto.view.getPurchaseAmount
import lotto.view.getWinningNumbers
import lotto.view.printHowManyPurchase
import lotto.view.printLottoTickets
import lotto.view.printProfit
import lotto.view.printResult

fun start() {
    val money = getMoney()
    val lottoCount = getLottoCount(money)
    printHowManyPurchase(lottoCount)
    val lottoTickets = getLottoTickets(lottoCount)
    val winningNumbers = WinningNumbers(getWinningNumbers(), getBonusNumber())
    val result = lottoTickets.matchWith(winningNumbers)
    printResult(result)
    printProfit(result.calculateProfit(money))
}

fun getMoney(): Money = Money.makeForBuyingLotto(getPurchaseAmount())

fun getLottoCount(money: Money): Int = money.run(Money::convertToLottoTicketCount)

fun getLottoTickets(count: Int): LottoTickets = LottoTickets.make(count).apply {
    printLottoTickets(this)
}
