package lotto2.application

import lotto2.domain.LottoMoney
import lotto2.domain.LottoNumbers
import lotto2.domain.LottoTicket
import lotto2.factory.AutoLottoGenerator
import lotto2.factory.LottoFactory
import lotto2.factory.ManualLottoGenerator

object LottoShop {
    const val LOTTO_PRICE = 1_000

    fun buyManualTicket(
        purchaseAmount: LottoMoney,
        manualTicketNumbers: List<LottoNumbers>,
        lottoFactory: LottoFactory = ManualLottoGenerator(manualTicketNumbers)
    ): List<LottoTicket> {
        purchaseAmount.subtract(manualTicketNumbers.size * LOTTO_PRICE)

        return lottoFactory.generate()
    }

    fun buyAutoTickets(
        purchaseAmount: LottoMoney,
        ticketQuantity: Int,
        lottoFactory: LottoFactory = AutoLottoGenerator(ticketQuantity)
    ): List<LottoTicket> {
        purchaseAmount.subtract(ticketQuantity * LOTTO_PRICE)

        return lottoFactory.generate()
    }
}
