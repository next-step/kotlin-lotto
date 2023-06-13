package lotto.controller

import lotto.model.LottoNumber
import lotto.model.LottoStore
import lotto.model.LottoTicket
import lotto.model.PurchasedLottoTickets
import lotto.model.RandomLottoTicketStorage
import lotto.view.InputView
import lotto.view.ResultView

object LoggoGame {
    private const val LOTTO_PRICE: Long = 1000
    private val LOTTO_STORE: LottoStore = LottoStore(RandomLottoTicketStorage(), LOTTO_PRICE)

    fun start() {
        val purchasedLottoTickets: PurchasedLottoTickets = LOTTO_STORE purchasedLottoTickets InputView.purchaseMoney
        ResultView.printTickets(purchasedLottoTickets.tickets)

        val winnerLottoTicket = LottoTicket(InputView.winnerNumbers.map { LottoNumber(it) }.toSet())
        ResultView.printScore(purchasedLottoTickets lottoScore winnerLottoTicket)
    }
}

fun main() {
    LoggoGame.start()
}