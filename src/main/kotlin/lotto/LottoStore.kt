package lotto

class LottoStore(private val issuer: LottoIssuable) {

    fun buy(money: Money): List<Lotto> {
        return emptyList()
    }
}
