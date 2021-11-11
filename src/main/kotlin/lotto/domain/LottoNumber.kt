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
        const val NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 번호는 숫자여야 합니다."

        val LOTTO_NUMBERS = (MIN_LOTTO_NUM..MAX_LOTTO_NUM).map { from(it) }

        fun from(value: Int): LottoNumber {
            return LOTTO_NUMBERS[value]
        }

        fun from(value: String): LottoNumber {
            return LOTTO_NUMBERS[value.toIntOrNull() ?: throw IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE)]
        }
    }
}
