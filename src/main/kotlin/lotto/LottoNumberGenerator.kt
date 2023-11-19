package lotto

class LottoNumberGenerator {
    fun generate(): List<LottoNumber> {
        return LottoNumber.LOTTO_NUMBERS.shuffled().take(TOTAL_COUNT).sortedBy { it.number }
    }

    companion object{
        private const val TOTAL_COUNT = 6
    }
}
