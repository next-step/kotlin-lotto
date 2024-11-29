package lotto.domain.lottonumber

class RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generateLottoNumbers(): List<Int> = LOTTO_NUMBER_RANGE.shuffled().subList(0, 6).sorted()

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
    }
}
