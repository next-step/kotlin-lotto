package lotto.domain.number

object RandomLottoLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return LottoNumber.getLottoNumbers()
            .shuffled()
            .take(count)
            .sortedBy { it.value }
            .toList()
    }
}
