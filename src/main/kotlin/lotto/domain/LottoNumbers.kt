package lotto.domain

data class LottoNumbers(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { INVALID_LOTTO_SIZE_ERROR_MESSAGE }
    }

    fun getNumberOfMatch(targetLottoNumbersNumbers: LottoNumbers): Int {
        return targetLottoNumbersNumbers.lottoNumbers.count {
            this.lottoNumbers.contains(it)
        }
    }

    fun isMatchBonusLottoNumber(bonusBall: LottoNumber) = lottoNumbers.contains(bonusBall)

    companion object {
        private const val LOTTO_SIZE = 6
        private const val INVALID_LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개의 숫자여야 합니다."
        private val TOTAL_LOTTO_NUMBER = (1..45).toList()

        fun createRandom(): LottoNumbers {
            val lottoNumbers = TOTAL_LOTTO_NUMBER.shuffled().take(LOTTO_SIZE).toSet()
            return LottoNumbers(lottoNumbers.map(LottoNumber::from).toSet())
        }
    }
}
