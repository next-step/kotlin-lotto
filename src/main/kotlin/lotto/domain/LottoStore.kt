package lotto.domain

object LottoStore {

    private val lottoNumberGenerator = LottoNumberGenerator { LOTTO_POOL.shuffled() }

    fun buyLottos(inputPrice: Int, manualLottoNumbers: List<LottoNumbers>): Lottos {
        val manualLottoCount = manualLottoNumbers.size
        val remainPrice = getRemainPrice(inputPrice, manualLottoCount)
        val autoLottoCount = remainPrice / LOTTO_PRICE
        if (remainPrice > 0) this.validateLottoBuy(autoLottoCount)
        return Lottos(
            List(autoLottoCount) { buyLotto() },
            manualLottoNumbers.map { Lotto(it) }
        )
    }

    private fun buyLotto(
        lottoNumbers: LottoNumbers =
            lottoNumberGenerator.takeShuffleNumber(LOTTO_POOL)
    ): Lotto {
        return Lotto(lottoNumbers)
    }

    private fun validateLottoBuy(lottoCount: Int) {
        require(lottoCount > 0) { LOTTO_BUY_ERROR_MESSAGE }
    }

    private fun getRemainPrice(inputPrice: Int, manualLottoCount: Int): Int {
        val manualPrice = manualLottoCount * LOTTO_PRICE
        require(inputPrice >= manualPrice) { LOTTO_BUY_ERROR_MESSAGE }
        return inputPrice - manualPrice
    }

    private const val LOTTO_PRICE = 1000
    private const val LOTTO_BUY_ERROR_MESSAGE = "로또를 구매할 수 없습니다."
    private val LOTTO_POOL = listOf(LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX)
        .flatten()
        .map { LottoNumber(it) }
}
