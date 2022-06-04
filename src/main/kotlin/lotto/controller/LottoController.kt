package lotto.controller

import lotto.domain.LottoCompany
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.YieldCalculator
import lotto.view.InputView
import lotto.view.OutputView

/**
 * Created by Jaesungchi on 2022.05.25..
 */
object LottoController {
    fun playLotto() {
        val money = InputView.getPrice()
        val manualCount = InputView.getManualCount()
        // 여기서 로또티켓으로 주는게 나을까 로또 번호들을 넘기는게 나으려나.
        val manualTickets = LottoTickets.of(InputView.getLottoNumbers(count = manualCount))
        val tickets = manualTickets + LottoStore().buyAutoLotto(money)
        OutputView.printTicket(tickets, manualCount)

        val company = LottoCompany.of(InputView.getWinningNumber(), InputView.getBonusNumber())
        val lottoResults = company.convertTicketsToLottoResults(tickets)
        OutputView.printLottoResult(lottoResults)
        OutputView.printYield(YieldCalculator.calculateYield(money, lottoResults))
    }
}
