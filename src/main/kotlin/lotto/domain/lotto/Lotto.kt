package lotto.domain.lotto

import lotto.domain.lotto.price.LottoTicketPrice
import lotto.domain.lotto.ticket.LottoTicketContainer

private const val DEFAULT_LOTTO_TICKET_PRICE = 1000

class Lotto(
    cost: Int,
    price: Int = DEFAULT_LOTTO_TICKET_PRICE
) {
    private val totalLottoTicketCount: Int
    val lottoTicketPrice: LottoTicketPrice = LottoTicketPrice(price)
    val lottoTicketList = LottoTicketContainer()

    init {
        require(cost > 0) { "Cost must be greater than zero" }
        require(price > 0) { "Price must be greater than zero" }
        require(cost >= price) { "Cost is less than price [$price]" }

        totalLottoTicketCount = cost.div(lottoTicketPrice.price)

        repeat(totalLottoTicketCount) {
            addLottoTicket()
        }
    }

    private fun addLottoTicket() {
        lottoTicketList.addLottoTicket()
    }

//    fun setLottoResult(lotto)
}
