package lotto

import lotto.view.getLuckyNumbers
import lotto.view.getMoneyForTickets
import lotto.view.printEarnRatio
import lotto.view.printLottoResults
import lotto.view.printLottoTickets

fun main() {
    val lottoShop = LottoShop(LottoTicketGenerator())
    val inputMoney = getMoneyForTickets()
    val lottoTickets = lottoShop.getAutoTickets(inputMoney)
    printLottoTickets(lottoTickets)

    lottoShop.setLuckyLottoNumbers(getLuckyNumbers())
    val results = lottoShop.getLottoResultsOf(lottoTickets)
    printLottoResults(results)
    printEarnRatio(EarnRatio.calculate(inputMoney, results))
}
