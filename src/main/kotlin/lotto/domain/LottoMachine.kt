package lotto.domain

class LottoMachine(
    private val lottoNumberGenerator: NumberGenerator = LottoNumberGenerator()
) {

    fun buyTickets(purchaseAmount: Int, manualLottoNumbers: List<LottoNumbers>): LottoTickets {
        require(purchaseAmount >= TICKET_PRICE) { "최소 구매 금액은 1000원 입니다. 입력한 구매 금액: [$purchaseAmount]" }

        val numberOfAutoTickets = getTotalNumberOfTickets(purchaseAmount) - manualLottoNumbers.size

        return List(numberOfAutoTickets) { lottoNumberGenerator.generate() }
            .run { manualLottoNumbers + this }
            .let { LottoTickets(it) }
    }

    private fun getTotalNumberOfTickets(purchaseAmount: Int): Int {
        return purchaseAmount / TICKET_PRICE
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}
