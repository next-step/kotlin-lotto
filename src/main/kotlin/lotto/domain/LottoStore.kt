package lotto.domain

object LottoStore : ShuffleNumber {

    fun buyLottos(inputPrice: Int): Lottos {
        val lottoCount = inputPrice / LOTTO_PRICE
        this.validateLottoBuy(lottoCount)
        return Lottos(List(lottoCount) { buyLotto() })
    }
    override fun shuffleNumber(): List<Int> {
        return listOf(LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
            .flatten()
            .shuffled()
    }

    private fun buyLotto(): Lotto {
        return Lotto(takeShuffleNumber(LOTTO_NUMBER_SIZE))
    }

    private fun validateLottoBuy(lottoCount: Int) {
        require(lottoCount > 0) { "로또를 구매할 수 없습니다." }
    }

    private const val LOTTO_PRICE = 1000
    const val LOTTO_NUMBER_SIZE = 6
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45
}
