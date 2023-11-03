package lottery.domain

class LottoGame(price: Int) {
    val quantity: Int
    private lateinit var lottos: Lottos

    init {
        quantity = price.div(LOTTERY_PRICE)
    }

    fun createLottoNumber() {
        lottos = Lottos.of(quantity, RandomNumberGenerator())
    }

    fun getLottos(): List<Lotto> {
        return lottos.lottos
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
    }
}
