package lotto.domain

class LottoTicketsCount(val manual: LottoTicketCount, val auto: LottoTicketCount) {

    companion object {
        fun of(manualCount: LottoTicketCount, money: LottoMoney): LottoTicketsCount {
            val autoCount = LottoTicketCount(money.calculateCount().value - manualCount.value)
            return LottoTicketsCount(manualCount, autoCount)
        }
    }
}
