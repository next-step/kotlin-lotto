package domain

class LottoStore(val price: Money, private val randomLottoNumberGenerator: RandomLottoNumberGenerator = CommonRandomLottoNumberGenerator()) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money): List<Lotto> {
        return (1..(countLottoToSellBy(money))).map { generateLotto() }
    }

    private fun countLottoToSellBy(money: Money) = money.dividedBy(price)

    private fun generateLotto() = Lotto(randomLottoNumberGenerator.generate())
}
