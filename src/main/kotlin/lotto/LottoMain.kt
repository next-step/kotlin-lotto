package lotto

import lotto.domain.LottoRewardCalculator
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.LottoWinningNumber
import lotto.presentation.InboundView
import lotto.presentation.OutboundView

fun main() {
    val inboundView = InboundView()
    val outboundView = OutboundView()

    val purchaseAmount: Int = inboundView.inputPurchaseAmount()
    val manualPurchaseCount: Int = inboundView.inputManualPurchaseCount()

    val manualPurchaseLottoTicket = inboundView.inputManualLottoNumber(manualPurchaseCount)
    val autoPurchaseLottoTicket = LottoStore.buyAutoLottoTicket(purchaseAmount, manualPurchaseCount)

    val lottoTickets = LottoTickets(manualPurchaseLottoTicket.lottoTickets + autoPurchaseLottoTicket.lottoTickets)

    outboundView.printLottoTickets(lottoTickets, manualPurchaseCount)

    val winningNumber: LottoWinningNumber = inboundView.inputWinningNumber()
    val lottoRewardCalculator = LottoRewardCalculator(lottoTickets, winningNumber)

    outboundView.printLottoMatchCount(lottoTickets, winningNumber)
    outboundView.printRewardRate(lottoRewardCalculator, purchaseAmount, LottoStore.LOTTO_TICKET_PRICE)
}
