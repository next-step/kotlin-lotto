package lotto.model

class LottoStore(private val price: Money = Money.thousand) {
    fun buy(money: Money): LottoTickets {
        val ticketCount = (money / price).toInt()

        return LottoTickets.issue(ticketCount)
    }
}
