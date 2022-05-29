package lotto.agency

class LottoNumberGenerator {
    fun getRandomLottoNumbers(): Set<Int> {
        return LOTTO_NUMBER_RANGE
            .shuffled()
            .slice(LOTTO_NUMBER_COUNT)
            .toSet()
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = IntRange(1, 45)
        private val LOTTO_NUMBER_COUNT = IntRange(1, 6)
    }
}
