package lotto.business

class RandomLottoPicker {
    fun pick(): Set<LottoNumber> {
        return LOTTO_NUMBERS.shuffled().take(LOTTO_NUMBER_COUNT).toSet()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
        private val LOTTO_NUMBERS = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
            .map { LottoNumber(it) }
            .toSet()
    }
}
