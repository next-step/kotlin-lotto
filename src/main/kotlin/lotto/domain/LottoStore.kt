package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_SIZE
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MAX
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MIN

object LottoStore : ShuffleNumber {

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

    override fun shuffleNumber(): List<LottoNumber> {
        return LOTTO_POOL.shuffled()
    }

    private fun buyLotto(
        lottoNumbers: LottoNumbers =
            takeShuffleNumber(LOTTO_NUMBER_SIZE)
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
    private val LOTTO_POOL = listOf(LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
        .flatten()
        .map { LottoNumber(it) }
}
