package lotto.domain

class Store(private val issuer: Issuable) {

    fun buy(money: Money): List<Lotto> =
        List(money.amount / LOTTO_PRICE) {
            issuer.issue()
        }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
