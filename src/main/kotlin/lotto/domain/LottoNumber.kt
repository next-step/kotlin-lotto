package lotto.domain

class LottoNumber private constructor(private val number: Int) {
    init {
        validate(number)
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        private val cache: Map<Int, LottoNumber> = (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).map {
            Pair(it, LottoNumber(it))
        }.toMap()

        fun from(number: Int): LottoNumber {
            return cache[number] ?: LottoNumber(number)
        }

        private fun validate(number: Int) {
            require(number in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
                "로또 번호는 $MINIMUM_LOTTO_NUMBER ~ $MAXIMUM_LOTTO_NUMBER 범위의 수여야 합니다."
            }
        }
    }
}
