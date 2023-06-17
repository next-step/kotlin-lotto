package lotto

@JvmInline
value class LottoNumber(
    private val numbers: List<Int> = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_SIZE),
) : List<Int> by numbers {

    init {
        val distinctNumbers = numbers.filter { LOTTO_NUMBER_RANGE.contains(it) }.distinct()
        require(distinctNumbers.size == LOTTO_NUMBER_SIZE) {
            "로또 번호는 $LOTTO_START_NUMBER ~ $LOTTO_END_NUMBER 사이에 중복없는 숫자 ${LOTTO_NUMBER_SIZE}개여야 합니다."
        }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        private const val LOTTO_NUMBER_SIZE = 6
        val LOTTO_NUMBER_RANGE = IntRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
    }
}
