package domain

class LottoStore(price: Money) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money): List<Lotto> {
        return emptyList()
    }
}
