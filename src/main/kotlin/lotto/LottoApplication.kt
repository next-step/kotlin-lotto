package lotto

import lotto.domain.EarnRatio
import lotto.domain.LottoMoney
import lotto.domain.LottoTicketDispenser
import lotto.domain.LottoTicketGenerator
import lotto.domain.LuckyLottoNumbers
import lotto.view.getBonusNumber
import lotto.view.getLuckyNumbers
import lotto.view.getManualLottoNumbersList
import lotto.view.getManualTicketCount
import lotto.view.getMoneyForTickets
import lotto.view.printEarnRatio
import lotto.view.printLottoResults
import lotto.view.printLottoTickets

fun main() {
    val lottoTicketDispenser = LottoTicketDispenser(LottoTicketGenerator())
    val inputMoney = LottoMoney(getMoneyForTickets())
    val manualTicketCount = getManualTicketCount()
    val manualLottoNumbersList = getManualLottoNumbersList(manualTicketCount)
    val manualLottoTickets = lottoTicketDispenser.getManualTickets(manualLottoNumbersList)

    val autoLottoTickets = lottoTicketDispenser.getAutoTickets(inputMoney.spendTicketCountOf(manualTicketCount))
    val allLottoTickets = manualLottoTickets + autoLottoTickets
    printLottoTickets(manualLottoTickets.size(), allLottoTickets)

    val luckyNumbers = getLuckyNumbers()
    val bonusNumber = getBonusNumber()
    val luckyLottoNumbers = LuckyLottoNumbers(bonusNumber = bonusNumber, luckyNumbers = *luckyNumbers)
    val results = luckyLottoNumbers.compare(allLottoTickets)

    printLottoResults(results)
    printEarnRatio(EarnRatio.calculate(inputMoney, results.getTotalPrize()))
}
