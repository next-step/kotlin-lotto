package lotto

import lotto.domain.LottoTicket
import lotto.domain.WinningTicket
import lotto.domain.machine.LottoFactory
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.inputMoney()
    val lottoFactory = LottoFactory(money)

    val manualCount = InputView.inputManualCount()
    require(lottoFactory.isBuyAble(manualCount)) { "수동으로 구매할 수 있는 최대 개수는 ${money / LottoTicket.PRICE} 입니다." }

    val manualLottoNumbers = InputView.inputManualLottoNumbers(manualCount)
    val tickets = lottoFactory.buyTickets(manualLottoNumbers)

    ResultView.printTickets(manualCount, tickets)

    val numbers = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val winningTicket = WinningTicket.of(numbers, bonusNumber)

    val awardResults = tickets.awardResults(winningTicket)
    ResultView.printResults(awardResults)

}

class LottoController {
}
