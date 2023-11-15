package lotto.domain.model

@JvmInline
value class Lotto private constructor(private val list: List<LottoNumber>) : List<LottoNumber> by list {

    init {
        require(list.size == LOTTO_NUMBER_COUNT) {
            "로또의 숫자 개수는 6입니다."
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        private val lottoNumberRange = (LottoNumber.LOTTO_NUMBER_START..LottoNumber.LOTTO_NUMBER_END)
        private val lottoNumbers: List<LottoNumber> = lottoNumberRange.map {
            LottoNumber(it)
        }

        fun valueOf(numbers: List<Int>): Lotto {
            return numbers.map {
                LottoNumber(it)
            }.let {
                Lotto(it)
            }
        }

        fun auto(): Lotto = lottoNumbers
            .shuffled()
            .take(6)
            .sortedBy {
                it.value
            }.let {
                Lotto(it)
            }
    }
}
