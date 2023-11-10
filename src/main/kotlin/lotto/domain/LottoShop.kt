package lotto.domain

class LottoShop(
    private val ticketGenerator: LottoTicketGenerator = LottoTicketGenerator(),
    private val price: Amount = Amount(1000)
) {

    fun purchase(amount: Amount): LottoTickets =
        List(calculateCount(amount)) {
            ticketGenerator.create()
        }.let(::LottoTickets)

    private fun calculateCount(amount: Amount): Int {
        require(amount % price == 0) { "구매 금액이 로또 금액의 배수여야 합니다" }
        return amount / price
    }
}
