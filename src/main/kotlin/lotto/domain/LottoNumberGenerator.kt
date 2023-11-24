package lotto.domain

class LottoNumberGenerator {
    fun generate(): Set<LottoNumber> {
        return LottoNumber.CACHED_NUMBER.shuffled().take(TOTAL_COUNT).sortedBy { it.number }.toSet()
    }

    companion object{
        private const val TOTAL_COUNT = 6
    }
}
