package lotto.domain

class LottoNumberGenerator {
    fun generate(size: Int): Set<LottoNumber> {
        return LottoNumber.CACHED_NUMBER.shuffled().take(size).sortedBy { it.number }.toSet()
    }
}
