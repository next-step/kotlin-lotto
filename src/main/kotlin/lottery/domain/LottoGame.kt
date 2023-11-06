package lottery.domain

class LottoGame(val price: Int, numberGenerator: LottoNumberGenerator = RandomNumberGenerator()) {
    private val lottos: Lottos

    init {
        lottos = Lottos.of(price.div(LOTTERY_PRICE), numberGenerator)
    }

    fun getLottos(): List<Lotto> {
        return lottos.lottos
    }

    fun getRanks(winningLotto: Lotto): Ranks {
        return Ranks(lottos, winningLotto, price)
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
    }
}
