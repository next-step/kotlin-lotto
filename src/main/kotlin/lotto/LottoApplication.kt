package lotto

import lotto.domain.EarnRatio
import lotto.domain.LottoNumber
import lotto.domain.LottoShop
import lotto.domain.LottoTicketGenerator
import lotto.view.getLuckyNumbers
import lotto.view.getMoneyForTickets
import lotto.view.printEarnRatio
import lotto.view.printLottoResults
import lotto.view.printLottoTickets

fun main() {
    println(LottoNumber.of(5))

    val lottoShop = LottoShop(LottoTicketGenerator())
    val inputMoney = getMoneyForTickets()
    val lottoTickets = lottoShop.getAutoTickets(inputMoney)
    printLottoTickets(lottoTickets)

    lottoShop.setLuckyLottoNumbers(getLuckyNumbers())
    val results = lottoShop.getLottoResultsOf(lottoTickets)
    printLottoResults(results)
    printEarnRatio(EarnRatio.calculate(inputMoney, results))
}
