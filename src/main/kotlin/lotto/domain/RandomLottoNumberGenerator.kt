package lotto.domain

class RandomLottoNumberGenerator : LottoNumberGenerator {

    private val numberPool = (MIN_NUMBER..MAX_NUMBER).map { LottoNumber(it) }

    override fun generate(): List<LottoNumber> {
        return numberPool.shuffled().take(LOTTO_NUMBER_COUNT).sortedBy { it.number }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
