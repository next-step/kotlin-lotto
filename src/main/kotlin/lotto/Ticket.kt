package lotto

class Ticket {
    private val _purchasedLotto = mutableListOf<Lotto>()
    val purchasedLottootto: List<Lotto> get() = _purchasedLotto

    fun buyTickets(pay: Int): Int {
        return pay / TICKET_PRICE
    }

    fun tickets(buyLottoTicket: Int) {
        repeat(buyLottoTicket) {
            _purchasedLotto.add(Lotto().apply { autoLotto() })
        }
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}
