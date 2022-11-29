package lotto.domain

data class LottoNumbers(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == MAXIMUM_LOTTO_SIZE) { INVALID_LOTTO_SIZE_ERROR_MESSAGE }
    }

    fun getNumberOfMatch(targetLottoNumbersNumbers: LottoNumbers): Int {
        return targetLottoNumbersNumbers.lottoNumbers.count {
            this.lottoNumbers.contains(it)
        }
    }

    fun isMatchBonusLottoNumber(bonusBall: LottoNumber) = lottoNumbers.contains(bonusBall)

    companion object {
        private const val MAXIMUM_LOTTO_SIZE = 6
        private const val INVALID_LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개의 숫자여야 합니다."

        fun createRandom(): LottoNumbers {
            return LottoNumbers(LottoVendingMachine.makeRandomLottoNumbers())
        }
    }
}
