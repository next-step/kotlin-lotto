package lotto

class Ticket {
    private val _purchasedLotto: MutableList<Lotto> = mutableListOf<Lotto>()
    val purchasedLotto: List<Lotto> get() = _purchasedLotto

    fun buyTickets(pay: Int): Int {
        return pay / TICKET_PRICE
    }

    fun tickets(buyLottoTicket: Int) {
        repeat(buyLottoTicket) {
            val lotto = Lotto().apply { generate(autoLotto()) }
            lotto.numbers
            _purchasedLotto.add(lotto)
        }
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}
