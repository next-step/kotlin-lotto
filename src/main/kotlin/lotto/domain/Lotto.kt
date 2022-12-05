package lotto.domain

class Lotto(private var count: Int = 0, val fee: Int) {

    constructor(fee: Int) : this(fee / PURCHASE_STANDARD_FEE, fee)

    fun getCount() = this.count

    fun purchaseTicket() = buildList { repeat(count) { add(Ticket()) } }

    companion object {
        const val PURCHASE_STANDARD_FEE = 1000
    }
}
