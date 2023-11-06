package lotto.business

class RandomLottoPicker {
    fun pick(): Set<LottoNumber> {
        return lottoNumbers.shuffled().take(LOTTO_NUMBER_COUNT).map { LottoNumber(it) }.toSet()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
        private val lottoNumbers = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).toList()
    }
}
