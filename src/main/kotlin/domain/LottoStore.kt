package domain

class LottoStore(val price: Money) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money): List<Lotto> {
        return (1..(money.value / price.value)).map { Lotto(1, 2, 3, 4, 5, 6) }
    }
}
