package lotto.domain

object RandomLottoNumberGenerator {
    private val lottoNumbers =
        (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)
            .map { number -> LottoNumber(number) }
            .toList()

    fun generate(): Set<LottoNumber> {
        return lottoNumbers.shuffled()
            .take(LottoNumbers.NUMBER_COUNT)
            .toSet()
    }
}
