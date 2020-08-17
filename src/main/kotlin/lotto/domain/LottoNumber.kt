package lotto.domain

data class LottoNumber(val number: Int) {

    private val lottoNumber = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)

    init {
        validateNumberRange(number)
    }

    private fun validateNumberRange(number: Int) {
        if (!lottoNumber.contains(number)) throw IllegalArgumentException("$number 는 로또 번호(1~45)가 아닙니다.")
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }
}
