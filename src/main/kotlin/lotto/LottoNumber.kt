package lotto

class LottoNumber(private val lottoNumber: List<Int>) : List<Int> by lottoNumber {

    init {
        val (withinRange, outOfRange) = lottoNumber.partition { LOTTO_NUMBER_RANGE.contains(it) }
        require(outOfRange.isEmpty()) { "로또 번호는 $LOTTO_START_NUMBER ~ $LOTTO_END_NUMBER 사이에 숫자여야 합니다." }
        require(withinRange.size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복이 없어야 합니다." }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBER_SIZE = 6
        val LOTTO_NUMBER_RANGE = IntRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
    }
}
