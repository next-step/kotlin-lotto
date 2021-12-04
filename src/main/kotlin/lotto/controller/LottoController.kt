package lotto.controller

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.view.getBonusNumber
import lotto.view.getManualLottoCount
import lotto.view.getManualLottoNumbers
import lotto.view.getPurchaseAmount
import lotto.view.getWinningNumbers
import lotto.view.printHowManyPurchase
import lotto.view.printLottoTickets
import lotto.view.printManualLottoNumbersComment
import lotto.view.printProfit
import lotto.view.printResult

fun start() {
    val money = getMoney()
    val totalLottoCount = getLottoCount(money)
    printHowManyPurchase(totalLottoCount)
    val manualLottoCount = getManualLottoCount()
    printManualLottoNumbersComment()
    val manualLottoTickets = List(manualLottoCount) {
        LottoTicket.generateByManual(getManualLottoNumbers())
    }
    val lottoTickets = getLottoTickets(totalLottoCount, manualLottoTickets)
    val winningNumbers = WinningNumbers(getWinningNumbers(), getBonusNumber())
    val result = lottoTickets.matchWith(winningNumbers)
    printResult(result)
    printProfit(result.calculateProfit(money))
}

fun getMoney(): Money = Money.makeForBuyingLotto(getPurchaseAmount())

fun getLottoCount(money: Money): Int = money.run(Money::convertToLottoTicketCount)

fun getLottoTickets(count: Int, manualLottoTickets: List<LottoTicket>): LottoTickets =
    LottoTickets.make(count, manualLottoTickets).also {
        printLottoTickets(it)
    }
