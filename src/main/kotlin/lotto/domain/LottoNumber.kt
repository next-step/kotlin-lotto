package lotto.domain

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    init {
        validateNumberRange(number)
    }

    private fun validateNumberRange(number: Int) {
        if (!LOTTO_NUMBER.contains(number)) throw IllegalArgumentException("$number 는 로또 번호(1~45)가 아닙니다.")
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        private val LOTTO_NUMBER = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        fun from(lottoNumbers: Int): LottoNumber {
            return LottoNumber(lottoNumbers)
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }
}
