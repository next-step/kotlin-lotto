package lotto.domain

const val LOTTO_SIZE = 6

class LottoMachine(
    private val lottoNumberGenerator: NumberGenerator = LottoNumberGenerator()
) {
    fun buyTickets(purchaseAmount: Int): LottoTickets {
        require(purchaseAmount >= 1000) { "최소 구매 금액은 1000원 입니다." }

        val numberOfTickets = getNumberOfTickets(purchaseAmount)
        val lottoTickets = List(numberOfTickets) { Numbers(lottoNumberGenerator.generate()) }

        return LottoTickets(lottoTickets)
    }

    private fun getNumberOfTickets(purchaseAmount: Int): Int {
        return purchaseAmount / TICKET_PRICE
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}