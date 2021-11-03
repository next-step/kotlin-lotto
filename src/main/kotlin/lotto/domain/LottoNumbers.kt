package lotto.domain

class LottoNumbers(private val lottoNumbers: List<Int>) {
    fun getNumbers(): List<Int> = lottoNumbers.map { it }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6

        fun generateLottoNumbers(lottoNumber: List<Int> = LottoNumberGenerator().generateRandomNumber()): LottoNumbers {
            require(lottoNumber.size == LOTTO_NUMBER_SIZE) { "숫자가 6개가 들어와야 합니다." }
            require(lottoNumber.distinct().size == LOTTO_NUMBER_SIZE) { "중복 된 숫자는 들어올 수 없습니다." }
            return LottoNumbers(lottoNumber.map { it })
        }
    }
}
