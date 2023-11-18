package lotto.data

data class Lotto(val selectNumbers: Set<LottoNumber>) {
    init {
        validateDuplication(selectNumbers)
    }

    private fun validateDuplication(lottoNumbers: Set<LottoNumber>) {
        require(lottoNumbers.size == LOTTO_NUMBER_LENGTH) { ERR_MSG_OUT_OF_LOTTO_LENGTH }
    }

    companion object {
        private const val LOTTO_NUMBER_LENGTH = 6
        private const val ERR_MSG_OUT_OF_LOTTO_LENGTH = "번호는 6개로 구성되어야 합니다."
    }
}
