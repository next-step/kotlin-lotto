package lotto.domain.model

@JvmInline
value class Lotto private constructor(private val set: Set<LottoNumber>) : Set<LottoNumber> by set {

    init {
        require(set.size == LOTTO_NUMBER_COUNT) {
            "로또의 숫자 개수는 6입니다."
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun valueOf(numbers: Iterable<Int>): Lotto {
            return numbers.mapTo(mutableSetOf()) {
                LottoNumber.get(it)
            }.let {
                Lotto(it)
            }
        }

        fun auto(): Lotto = LottoNumber.lottoNumbers
            .shuffled()
            .take(6)
            .toSortedSet(
                compareBy { it.value }
            ).let {
                Lotto(it)
            }
    }
}
