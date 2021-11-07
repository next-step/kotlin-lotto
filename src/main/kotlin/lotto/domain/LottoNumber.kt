package lotto.domain

@JvmInline
value class LottoNumber private constructor(
    val number: Int
) {

    init {
        require(number in MIN_LOTTO_NUM..MAX_LOTTO_NUM) { WRONG_LOTTO_NUM_MESSAGE }
    }

    companion object {
        const val MIN_LOTTO_NUM = 1
        const val MAX_LOTTO_NUM = 45
        const val WRONG_LOTTO_NUM_MESSAGE = "잘못된 로또 번호입니다."

        val LOTTO_NUMBERS = (MIN_LOTTO_NUM..MAX_LOTTO_NUM).map { of(it) }

        fun of(value: Int): LottoNumber {
            return LottoNumber(value)
        }
    }
}
