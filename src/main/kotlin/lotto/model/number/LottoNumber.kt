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
            validate(lottoNumber)

            return LOTTO_NUMBERS[lottoNumber - 1]
        }

        private fun validate(lottoNumber: Int) {
            require(lottoNumber in MINIMUM..MAXIMUM) { "로또 숫자는 1부터 45 까지의 자연수입니다!" }
        }
    }
}
