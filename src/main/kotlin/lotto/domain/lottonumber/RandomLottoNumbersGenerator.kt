package lotto.domain.lottonumber

class RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generate(): List<Int> = LOTTO_NUMBER_RANGE.shuffled().subList(START_INDEX, LOTTO_NUMBER_COUNT).sorted()

    companion object {
        private const val START_INDEX = 0
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = 1..45
    }
}
