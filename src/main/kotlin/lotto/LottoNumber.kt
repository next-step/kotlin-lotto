package lotto

class LottoNumber(
    private val numbers: List<Int> = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_SIZE)
) : List<Int> by numbers {

    init {
        val (withinRange, outOfRange) = numbers.partition { LOTTO_NUMBER_RANGE.contains(it) }
        require(outOfRange.isEmpty()) { "로또 번호는 $LOTTO_START_NUMBER ~ $LOTTO_END_NUMBER 사이에 숫자여야 합니다." }
        require(withinRange.size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복이 없어야 합니다." }
    }

    fun countMatchNumbers(winLottoNumber: LottoNumber): Int {
        val matchNumbers = this.filter { winLottoNumber.contains(it) }
        return matchNumbers.size
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_NUMBER_SIZE = 6
        private val LOTTO_NUMBER_RANGE = IntRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
    }
}
