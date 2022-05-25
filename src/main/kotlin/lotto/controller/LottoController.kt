package lotto.controller

import lotto.domain.LottoCompany
import lotto.domain.LottoStore
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

        val company = LottoCompany(InputView.getWinningNumber())
        val prizes = tickets.mapNotNull { company.findCorrectLotto(it) }
        val lottoResults = company.convertPrizeToLottoResult(prizes)
        OutputView.printLottoResult(lottoResults)
    }
}
