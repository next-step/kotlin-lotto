package lotto

class RandomLottoGenerator {

    private val lottoNumberPool: List<LottoNumber> = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }

    fun generate(): Lotto {
        return lottoNumberPool.shuffled().subList(0, LOTTO_NUMBER_COUNT).let { Lotto(it) }
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
