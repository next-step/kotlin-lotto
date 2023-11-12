package lotto.domain

class LottoShop(
    private val price: Amount = Amount(1000)
) {

    fun purchase(amount: Amount): LottoTicket =
        List(calculateCount(amount)) {
            LottoNumberGenerator.createFrom()
        }.let(::LottoTicket)

    fun receivePrize(ticket: LottoTicket, winningLotto: WinningLotto): LottoResult =
        LottoResult.of(winningLotto, ticket, price)

    private fun calculateCount(amount: Amount): Int {
        require(amount % price == 0) { "구매 금액이 로또 금액의 배수여야 합니다" }
        return amount / price
    }
}
