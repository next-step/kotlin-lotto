package lottery.domain

class LottoGame(private val price: Int, private val lottos: Lottos) {

    constructor(price: Int, numberGenerator: LottoNumberGenerator = RandomNumberGenerator()) : this(
        price,
        Lottos(price.div(LOTTERY_PRICE), numberGenerator)
    )

    fun getLottos(): List<Lotto> {
        return lottos.lottos
    }

    fun getRanks(winningLotto: WinningLotto): Ranks {
        return Ranks(lottos, winningLotto, price)
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }
}
