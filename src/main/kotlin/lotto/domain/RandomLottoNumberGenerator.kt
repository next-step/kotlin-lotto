package lotto.domain

object RandomLottoNumberGenerator : LottoNumberGenerator {
    private val numberRange: IntRange = (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)

    override fun generateNumbers(): List<LottoNumber> {
        return numberRange.shuffled()
            .map { LottoNumber(it) }
            .take(Lotto.NUMBER_COUNT)
            .sortedBy { it.number }
    }
}
