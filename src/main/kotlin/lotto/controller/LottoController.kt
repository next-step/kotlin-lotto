package lotto.controller

import lotto.domain.LottoCompany
import lotto.domain.LottoStore
import lotto.domain.YieldCalculator
import lotto.view.InputView
import lotto.view.OutputView

/**
 * Created by Jaesungchi on 2022.05.25..
 */
object LottoController {
    fun playLotto() {
        val money = InputView.getPrice()
        val tickets = LottoStore().buyLotto(money)
        OutputView.printTicket(tickets)

        val company = LottoCompany.of(InputView.getWinningNumber(), InputView.getBonusNumber())
        val lottoResults = company.convertTicketsToLottoResults(tickets)
        OutputView.printLottoResult(lottoResults)
        OutputView.printYield(YieldCalculator.calculateYield(money, lottoResults))
    }
}
