package lotto

class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) { LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE }
    }

    companion object {
        const val MAX = 45
        const val MIN = 1
        val LOTTO_NUMBER_RANGE = (MIN..MAX)
        const val LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE = "$MIN 에서 $MAX 사이의 숫자만 가능합니다."
    }
}
