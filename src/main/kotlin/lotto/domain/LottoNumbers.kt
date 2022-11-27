package lotto.domain

data class LottoNumbers(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.distinct().size == MAXIMUM_LOTTO_SIZE) { INVALID_LOTTO_SIZE_ERROR_MESSAGE }
    }
    fun getLottoNumbers() = lottoNumbers

    fun getNumberOfMatch(targetLottoNumbers: LottoNumbers): Int {
        return targetLottoNumbers.lottoNumbers.count {
            this.lottoNumbers.contains(it)
        }
    }
    companion object {
        private const val ZERO = 0
        private const val MAXIMUM_LOTTO_SIZE = 6
        private const val INVALID_LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개의 숫자여야 합니다."
        fun createRandom(): LottoNumbers {
            val allLottoNumbers = LottoNumber.getAllLottoNumbers()
            val shuffledLottoNumbers = allLottoNumbers.shuffled()

            return LottoNumbers(shuffledLottoNumbers.subList(ZERO, MAXIMUM_LOTTO_SIZE))
        }
    }
}
