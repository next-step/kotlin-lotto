package lotto.domain

class LottoNumber private constructor(val number: Int) {

    override fun toString(): String {
        return "$number"
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        private val cache: Array<LottoNumber> = Array(MAXIMUM_LOTTO_NUMBER + 1){ LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            validate(number)

            return cache[number]
        }

        private fun validate(number: Int) {
            require(number in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
                "로또 번호는 $MINIMUM_LOTTO_NUMBER ~ $MAXIMUM_LOTTO_NUMBER 범위의 수여야 합니다."
            }
        }
    }

}