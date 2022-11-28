package lotto.domain.lotto.price

data class LottoCost(val inputCost: Int, val lottoTicketPrice: LottoTicketPrice = LottoTicketPrice()) {

    val ticketCount: Int = inputCost.div(lottoTicketPrice.price)

    val ticketCost: Int = ticketCount * lottoTicketPrice.price

    init {
        require(inputCost > 0) {
            "Cost must be greater than zero"
        }

        require(inputCost >= lottoTicketPrice.price) {
            "Cost is less than price [${lottoTicketPrice.price}]"
        }
    }
}
