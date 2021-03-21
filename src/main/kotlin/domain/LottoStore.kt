package domain

class LottoStore(val price: Money) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money): List<Lotto> {
        return (1..(countLottoToSellBy(money))).map { generateLotto() }
    }

    private fun countLottoToSellBy(money: Money) = money.dividedBy(price)

    private fun generateLotto() = Lotto(1, 2, 3, 4, 5, 6)
}
