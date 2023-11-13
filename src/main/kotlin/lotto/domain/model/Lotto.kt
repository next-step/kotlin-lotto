package lotto.domain.model

@JvmInline
value class Lotto private constructor(private val list: List<LottoNumber>) : List<LottoNumber> by list {

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        private val lottoNumberRange = (LottoNumber.LOTTO_NUMBER_START..LottoNumber.LOTTO_NUMBER_END)
        private val lottoNumbers: List<LottoNumber> = lottoNumberRange.map {
            LottoNumber.valueOf(it)
        }

        fun valueOf(list: List<LottoNumber>): Lotto {
            require(list.size == LOTTO_NUMBER_COUNT) {
                "로또의 숫자 개수는 6입니다."
            }
            return Lotto(list)
        }

        fun valueOf(numbers: String): Lotto {
            return numbers.split(",")
                .map {
                    it.trim()
                }.map {
                    LottoNumber.valueOf(it)
                }.let {
                    valueOf(it)
                }
        }

        fun auto(): Lotto = lottoNumbers
            .shuffled()
            .subList(0, 6)
            .sortedBy {
                it.value
            }.let {
                valueOf(it)
            }
    }
}
