package lotto.business

class RandomLottoPicker {
    fun pick(): List<LottoNumber> {
        return lottoNumbers.shuffled().take(LOTTO_NUMBER_COUNT).map { LottoNumber(it) }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
        private val lottoNumbers = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).toList()
    }
}
