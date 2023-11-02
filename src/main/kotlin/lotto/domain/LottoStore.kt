package lotto.domain

import lotto.constants.Sort

object LottoStore {

    fun buyLotto(): Lotto {
        return Lotto(lottoNumberShuffle().lottoNumberSort())
    }
    fun buyLottos(inputPrice: Int): List<Lotto> {
        val lottoCount = inputPrice / LOTTO_PRICE
        this.validateLottoBuy(lottoCount)
        return(1..lottoCount).map { buyLotto() }
    }

    private fun lottoNumberShuffle(): List<Int> {
        return listOf(LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
            .flatten()
            .shuffled()
            .take(LOTTO_NUMBER_SIZE)
    }

    private fun List<Int>.lottoNumberSort(sort: Sort = Sort.ASC): List<Int> {
        if (sort == Sort.DESC) {
            return this.sortedDescending()
        }
        return this.sorted()
    }

    private fun validateLottoBuy(lottoCount: Int) {
        require(lottoCount > 0) { throw RuntimeException("로또를 구매할 수 없습니다.") }
    }

    private const val LOTTO_PRICE = 1000
    const val LOTTO_NUMBER_SIZE = 6
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45
}
