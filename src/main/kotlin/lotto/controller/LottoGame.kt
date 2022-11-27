package lotto.controller

import lotto.model.LottoTicket
import lotto.model.Quantity
import lotto.model.WinnerNumber
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame {
    private val resultView = ResultView()
    private val inputView = InputView()
    private val lottoTickets = mutableListOf<LottoTicket>()

    fun start() {
        val quantity = Quantity(InputView().getAmountOfMoney()).quantity
        resultView.showQuantity(quantity)

        purchaseLottoTicket(quantity)

        drawWinnerNumber(WinnerNumber(inputView.getWinnerNumber()))
    }

    fun purchaseLottoTicket(quantity: Int): List<LottoTicket> {
        for (i in 0 until quantity) {
            lottoTickets.add(LottoTicket().make())
            resultView.showLottoTicket(lottoTickets[i].getLottoTicketNumbers())
        }
        return lottoTickets
    }

    fun drawWinnerNumber(winnerNumber: WinnerNumber) {
        // TODO : 구현하기
    }
}
