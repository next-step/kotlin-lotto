package lotto

import lotto.domain.LottoRewardCalculator
import lotto.domain.LottoStore
import lotto.domain.LottoWinningNumber
import lotto.domain.collection.LottoTickets
import lotto.presentation.InboundView
import lotto.presentation.OutboundView

fun main() {
    val inboundView = InboundView()
    val outboundView = OutboundView()

    val purchaseAmount: Int = inboundView.inputPurchaseAmount()
    val lottoTickets: LottoTickets = LottoStore.buyLottoTicket(purchaseAmount)

    outboundView.printLottoTickets(lottoTickets)

    val winningNumber: LottoWinningNumber = inboundView.inputWinningNumber()
    val lottoRewardCalculator = LottoRewardCalculator(lottoTickets, winningNumber)

    outboundView.printLottoMatchCount(lottoTickets, winningNumber)
    outboundView.printRewardRate(lottoRewardCalculator, purchaseAmount, LottoStore.getLottoTicketPrice())
}
