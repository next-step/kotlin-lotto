package lotto.domain

object LottoNumberGenerator {
    private val numberRange: IntRange = (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)

    fun generateNumbers(): List<LottoNumber> {
        return numberRange.shuffled()
            .map { LottoNumber(it) }
            .take(Lotto.NUMBER_COUNT)
            .sortedBy { it.number }
    }
}
