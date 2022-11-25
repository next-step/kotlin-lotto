package lotto.domain

class Lotto(private var count: Int = 0) {

    fun setCountByPurchaseFee(fee: Int) {
        count = fee / PURCHASE_FEE
    }

    fun getCount() = this.count

    fun purchaseTicket() = buildList { repeat(count) { add(Ticket()) } }

    companion object {
        const val PURCHASE_FEE = 1000
    }
}
