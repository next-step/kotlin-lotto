package lotto.domain

object LottoNumbers {
    private val LOTTO_NUMBER_RANGE = 1..45
    private val numbers = (LOTTO_NUMBER_RANGE).toSet()
    private const val INVALID_VALUE_ERROR_MESSAGE = "로또 번호는 1 ~ 45 사이의 숫자여야 합니다."

    private val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()

    fun convertToLottoNumber(number: Int): LottoNumber {
        return validateLottoNumber(number)
    }

    private fun validateLottoNumber(number: Int): LottoNumber {
        return lottoNumbers.firstOrNull{it.number == number}
            ?: throw IllegalArgumentException(INVALID_VALUE_ERROR_MESSAGE)
    }
}