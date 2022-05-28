package lotto.domain

class Store(private val issuer: Issuable) {

    fun buy(request: PurchaseRequest): List<Lotto> =
        List(request.money.amount / LOTTO_PRICE) {
            issuer.issue()
        }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
