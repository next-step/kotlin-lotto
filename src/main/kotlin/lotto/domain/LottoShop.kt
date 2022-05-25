package lotto.domain

import lotto.vo.Money

class LottoShop(private val lottoMachine: LottoMachine = DefaultLottoMachine) {
    fun buying(amount: Money, manualNumbers: List<String> = emptyList()): LottoTickets {
        require(amount >= manualTicketsAmount(manualNumbers)) {
            "구매 금액이 부족합니다"
        }

        val autoCount = amount / LOTTO_TICKET_PRICE - manualNumbers.size
        val manualLottoTickets = manualNumbers.map(lottoMachine::generateManual)
        val autoLottoTickets = List(autoCount) { lottoMachine.generateAuto() }
        return LottoTickets(manualLottoTickets + autoLottoTickets)
    }

    private fun manualTicketsAmount(manualNumbers: List<String>) =
        LOTTO_TICKET_PRICE.multiply(manualNumbers.size)

    companion object {
        val LOTTO_TICKET_PRICE = Money.of(1_000)
    }
}
