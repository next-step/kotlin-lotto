package lotto.agency

class LottoNumberGenerator {
    fun getRandomLottoNumbers(): List<LottoNumber> {
        return LOTTO_NUMBER_RANGE
            .shuffled()
            .slice(LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) }
            .toList()
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = IntRange(1, 45)
        private val LOTTO_NUMBER_COUNT = IntRange(1, 6)
    }
}
