package lotto.domain

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    init {
        validateNumberRange(number)
    }

    private fun validateNumberRange(number: Int) {
        if (!LOTTO_NUMBERS.contains(number)) throw IllegalArgumentException("$number$NOT_ENOUGH_LOTTO_NUM")
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        const val NOT_ENOUGH_LOTTO_NUM = "는 로또 번호($LOTTO_MIN_NUMBER~$LOTTO_MAX_NUMBER)가 아닙니다."
        val LOTTO_NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
    }

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }
}
