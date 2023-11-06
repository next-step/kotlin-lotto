package lotto.domain

object LottoAccountant {
    fun calculateTicketCount(amountToPurchase: Amount, ticketPrice: Amount = LottoSpec.PRICE): TicketCount =
        TicketCount(calculateCount(amountToPurchase, ticketPrice))

    fun calculateTotalPrize(
        results: List<LottoResult>,
        prizeInfo: List<WinningPrize>
    ): Amount = results.fold(Amount(0)) { total, result ->
        total + result.calculatePrize(prizeInfo)
    }

    private fun calculateCount(amount: Amount, ticketPrice: Amount): Int {
        require(amount % ticketPrice == 0) { "로또를 구매하려면 구매 금액이 로또 금액의 배수여야 합니다" }
        return amount / LottoSpec.PRICE
    }
}

