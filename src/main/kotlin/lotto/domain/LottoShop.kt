package lotto.domain

import lotto.vo.Money

class LottoShop(private val lottoMachine: LottoMachine = DefaultLottoMachine) {
    fun buying(buyingAmount: Money, manualNumbers: List<List<LottoNumber>> = emptyList()): LottoTickets {
        require(buyingAmount >= manualTicketsAmount(manualNumbers)) {
            "구매 금액이 부족합니다"
        }

        val autoCount = buyingAmount / LOTTO_TICKET_PRICE - manualNumbers.size
        val manualLottoTickets = manualNumbers.map(lottoMachine::generateManual)
        val autoLottoTickets = List(autoCount) { lottoMachine.generateAuto() }
        return LottoTickets(manualLottoTickets + autoLottoTickets)
    }

    private fun manualTicketsAmount(manualNumbers: List<List<LottoNumber>>) =
        LOTTO_TICKET_PRICE.multiply(manualNumbers.size)

    companion object {
        val LOTTO_TICKET_PRICE = Money.of(1_000)
    }
}
