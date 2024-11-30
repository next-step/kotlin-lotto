package lotto

object RandomLottoNumberGenerator {
    private val lottoNumbers = (Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER).toList()

    fun generate(): Set<Int> {
        return lottoNumbers.shuffled()
            .take(Lotto.NUMBER_COUNT)
            .toSet()
    }
}
