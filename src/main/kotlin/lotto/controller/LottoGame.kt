package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoStore
import lotto.model.LottoTicketStorage
import lotto.model.ManualLottoTicketStorage
import lotto.model.PurchasedLottoTickets
import lotto.model.RandomLottoTicketStorage
import lotto.model.WinnerLottoTicket
import lotto.view.InputView
import lotto.view.ResultView

object LottoGame {
    private const val LOTTO_PRICE: Long = 1_000

    fun start() {
        val purchaseMoney: Long = InputView.purchaseMoney
        val manualBuyCount: Int = InputView.manualLottoCount
        val purchasedLottoTickets: PurchasedLottoTickets =
            lottoStore(manualBuyCount)
                .purchaseLottoTicketsBy(manualBuyCount, purchaseMoney)

        ResultView.printTickets(purchasedLottoTickets.tickets)
        ResultView.printScore(purchasedLottoTickets scoreBy winnerLottoTicket)
    }

    private fun lottoStore(manualBuyCount: Int): LottoStore {
        return LottoStore(
            mainLottoTicketStorage = manualLottoTicketsStorage(manualBuyCount),
            subLottoTicketStorage = RandomLottoTicketStorage,
            price = LOTTO_PRICE
        )
    }

    private fun manualLottoTicketsStorage(manualBuyCount: Int): LottoTicketStorage {
        return ManualLottoTicketStorage(manualLottoGroup(manualBuyCount))
    }

    private fun manualLottoGroup(manualBuyCount: Int): Collection<Lotto> {
        return InputView.manualLottoNumbers(manualBuyCount).map { Lotto(it.map(::LottoNumber).toSet()) }
    }

    private val winnerLottoTicket: WinnerLottoTicket
        get() {
            return WinnerLottoTicket(
                Lotto(InputView.winnerNumbers.map { LottoNumber(it) }.toSet()),
                LottoNumber(InputView.bonusBall)
            )
        }
}

fun main() {
    LottoGame.start()
}
