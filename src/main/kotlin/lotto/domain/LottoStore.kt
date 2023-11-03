package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_SIZE
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MAX
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MIN

object LottoStore : ShuffleNumber {

    fun buyLottos(inputPrice: Int): Lottos {
        val lottoCount = inputPrice / LOTTO_PRICE
        this.validateLottoBuy(lottoCount)
        return Lottos(List(lottoCount) { buyLotto() })
    }
    override fun shuffleNumber(): List<Int> {
        return LOTTO_POOL.flatten().shuffled()
    }

    private fun buyLotto(): Lotto {
        return Lotto(takeShuffleNumber(LOTTO_NUMBER_SIZE))
    }

    private fun validateLottoBuy(lottoCount: Int) {
        require(lottoCount > 0) { "로또를 구매할 수 없습니다." }
    }

    private const val LOTTO_PRICE = 1000
    private val LOTTO_POOL = listOf(LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
}
