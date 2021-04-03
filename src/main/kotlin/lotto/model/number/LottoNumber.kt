package lotto.model.number

data class LottoNumber private constructor(private val lottoNumber: Int) : Comparable<LottoNumber> {
    override fun compareTo(other: LottoNumber): Int {
        return this.lottoNumber.compareTo(other.lottoNumber)
    }

    companion object {
        private const val MINIMUM = 1
        const val MAXIMUM = 45

        private val LOTTO_NUMBERS = (MINIMUM..MAXIMUM).map { LottoNumber(it) }

        fun get(lottoNumber: Int): LottoNumber {
            return LOTTO_NUMBERS.getOrNull(lottoNumber - 1)
                ?: throw IllegalArgumentException("로또 숫자는 $MINIMUM 부터 $MAXIMUM 까지의 자연수입니다!")
        }
    }
}
