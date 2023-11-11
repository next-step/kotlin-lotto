package lotto.domain

class LottoShop(
    private val price: Amount = Amount(1000)
) {

    fun purchase(amount: Amount): LottoTickets =
        List(calculateCount(amount)) {
            LottoTicketGenerator.create()
        }.let(::LottoTickets)

    fun calculateEarningRatioOf(tickets: LottoTickets, winningLotto: WinningLotto): EarningRate {
        val result = tickets.result ?: (tickets determineResultBy winningLotto)
        return EarningRate.of(
            purchasedAmount = tickets.calculatePrice(price),
            earningAmount = result.totalPrize
        )
    }

    private fun calculateCount(amount: Amount): Int {
        require(amount % price == 0) { "구매 금액이 로또 금액의 배수여야 합니다" }
        return amount / price
    }
}
