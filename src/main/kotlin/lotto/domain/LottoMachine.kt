package lotto.domain

import lotto.domain.Lotto.Companion.PRICE

class LottoMachine(
    private val lottoGenerator: LottoGenerator = LottoGenerator(),
) {
    fun draw(ticket: LottoTicket): Lotto =
        Lotto(ticket.manualLottoNumbers + List(ticket.autoLottoNumbersSize) { lottoGenerator.generate() })

    private fun countPurchaseLotto(price: Int): Int {
        require(price >= PRICE) { "로또를 구매하려면 최소 ${PRICE}원 이상의 금액이 필요합니다." }
        return price / PRICE
    }
}
