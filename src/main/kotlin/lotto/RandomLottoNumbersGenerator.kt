package lotto

class RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generate(): Set<Int> {
        return CACHE.shuffled()
            .take(Lotto.LOTTO_SIZE)
            .toSet()
    }

    companion object {
        private val CACHE = (Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER)
    }
}
