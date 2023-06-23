package lotto

class LottoMachine(
    private val lottoNumberGenerator: NumberGenerator = LottoNumberGenerator()
) {
    fun getNumberOfTickets(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) {
            "최소 구매 금액은 1000원 입니다."
        }
        return purchaseAmount / TICKET_PRICE
    }

    fun issueTicket(numberOfTickets: Int): LottoTicket {
        val lottoTickets = mutableListOf<Numbers>()
        repeat(numberOfTickets) {
            lottoTickets.add(Numbers(lottoNumberGenerator.generate()))
        }
        return LottoTicket(lottoTickets.toList())
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}