package lotto.domain

class Lotto(val numbers: Set<Int> = createLottoNumbers()) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 당첨 번호는 6개입니다." }
        require(checkRangeLottoNumber(numbers)) {
            "로또 번호는 ${LOTTO_NUMBER_RANGE.first}부터 ${LOTTO_NUMBER_RANGE.last}까지 입니다."
        }
    }

    private fun checkRangeLottoNumber(numbers: Set<Int>): Boolean {
        return numbers
            .filterNot { num -> num in LOTTO_NUMBER_RANGE }
            .isEmpty()
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
        fun createLottoNumbers() =
            (LOTTO_NUMBER_RANGE).shuffled().subList(0, LOTTO_NUMBER_COUNT)
                .sorted()
                .toSet()
    }
}
