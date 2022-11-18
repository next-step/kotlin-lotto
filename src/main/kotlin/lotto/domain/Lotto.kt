package lotto.domain


class Lotto {
    var numbers: List<Int> = createLottoNumbers().sorted()
        private set

    companion object {
        const val LOTTO_NUMBER_RANGE_START = 1
        const val LOTTO_NUMBER_RANGE_END = 45
        const val LOTTO_NUMBER_COUNT = 6
        fun createLottoNumbers() =
            (LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END).shuffled().subList(0, LOTTO_NUMBER_COUNT)
    }
}
