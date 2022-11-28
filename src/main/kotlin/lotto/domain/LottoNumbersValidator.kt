package lotto.domain

object LottoNumbersValidator {
    private val LOTTO_NUMBER_RANGE = 1..45
    private const val LOTTO_NUMBER_SIZE = 6

    fun validate(lottoNumbers: List<Int>): Boolean {
        return validateLottoNumbersCount(lottoNumbers) && validateLottoNumbersRange(lottoNumbers)
    }

    private fun validateLottoNumbersCount(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.size == LOTTO_NUMBER_SIZE
    }

    private fun validateLottoNumbersRange(lottoNumbers: List<Int>): Boolean {
        return LOTTO_NUMBER_RANGE.toList().containsAll(lottoNumbers)
    }
}