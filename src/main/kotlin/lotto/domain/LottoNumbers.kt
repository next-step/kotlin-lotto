package lotto.domain

class LottoNumbers(numbers: List<LottoNumber>) {
    private val lottoNumbers: List<LottoNumber> = numbers.sortedBy { it.number }

    init {
        require(numbers.size == EXPECTED_LOTTO_NUMBER_SIZE) { INIT_ERROR_MESSAGE }
    }

    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers
    }

    companion object {
        private const val INIT_ERROR_MESSAGE: String = "로또 번호는 6개여야 합니다."
        private const val EXPECTED_LOTTO_NUMBER_SIZE: Int = 6
    }
}
