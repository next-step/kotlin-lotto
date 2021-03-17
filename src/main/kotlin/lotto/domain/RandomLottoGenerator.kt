package lotto.domain

class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        return LOTTO_NUMBER_POOL.shuffled().subList(0, LOTTO_NUMBER_COUNT).let { Lotto(it) }
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_POOL = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }
    }
}
