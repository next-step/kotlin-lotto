package lotto

import lotto.domain.EarnRatio
import lotto.domain.LottoShop
import lotto.domain.LottoTicketGenerator
import lotto.domain.LuckyLottoNumbers
import lotto.view.getBonusNumber
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

    val luckyNumbers = getLuckyNumbers()
    val bonusNumber = getBonusNumber()
    val luckyLottoNumbers = LuckyLottoNumbers(bonusNumber = bonusNumber, luckyNumbers = *luckyNumbers)
    val results = luckyLottoNumbers.compare(lottoTickets)

    printLottoResults(results)
    printEarnRatio(EarnRatio.calculate(inputMoney, results.getTotalPrize()))
}
