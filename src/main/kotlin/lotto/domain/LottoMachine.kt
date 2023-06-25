package lotto.domain

import lotto.domain.LottoNumbers.Companion.toNumbers

class LottoMachine(
    private val lottoNumberGenerator: NumberGenerator = LottoNumberGenerator()
) {
    fun buyTickets(purchaseAmount: Int): LottoTickets {
        require(purchaseAmount >= TICKET_PRICE) { "최소 구매 금액은 1000원 입니다. 입력 구매 금액: [$purchaseAmount]" }

        val numberOfTickets = getNumberOfTickets(purchaseAmount)

        return List(numberOfTickets) {
            lottoNumberGenerator.generate()
                .toNumbers()
        }.let { LottoTickets(it) }
    }

    private fun getNumberOfTickets(purchaseAmount: Int): Int {
        return purchaseAmount / TICKET_PRICE
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}