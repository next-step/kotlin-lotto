package lotto.domain

object LottoGenerator {
    fun generateNumbers(): Set<LottoNumber> {
        return (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER).shuffled()
            .take(6)
            .sorted()
            .map { LottoNumber.get(it) }
            .toSet()
    }
}
