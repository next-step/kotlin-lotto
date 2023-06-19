package lotto

class LottoNumber private constructor(val number: Int) {
    companion object {
        const val MAX = 45
        const val MIN = 1
        val LOTTO_NUMBER_RANGE: IntRange = (MIN..MAX)
        const val LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE = "$MIN 에서 $MAX 사이의 숫자만 가능합니다. number:%d"
        val LOTTO_NUMBER_POOL: List<LottoNumber> = LOTTO_NUMBER_RANGE.toList().map { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            require(number in LOTTO_NUMBER_RANGE) { LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE.format(number) }

            return LOTTO_NUMBER_POOL[number - 1]
        }
    }
}
