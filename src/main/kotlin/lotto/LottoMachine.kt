package lotto

class LottoMachine {
    fun getNumberOfTickets(purchaseAmount: Int): Int {
        return (purchaseAmount / TICKET_PRICE).toInt()
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}