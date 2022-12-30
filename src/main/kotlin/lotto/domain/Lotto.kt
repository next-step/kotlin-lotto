package lotto.domain

class Lotto(private var count: Int = 0, val fee: Int) {

    constructor(fee: Int) : this(fee / PURCHASE_STANDARD_FEE, fee)

    fun getCount() = this.count

    fun purchaseTicket(manualTicket: List<String>) = buildList {
        repeat(count - manualTicket.size) { add(Ticket()) }
        manualTicket.forEach { add(Ticket(it)) }
    }

    companion object {
        const val PURCHASE_STANDARD_FEE = 1000
    }
}
