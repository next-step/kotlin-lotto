package next.step.lotto.domain

object LottoNumberGenerator {

    private val lottoNumbers: List<LottoNumber> =
        (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER).map { LottoNumber.of(it) }

    fun random(): Set<LottoNumber> {
        return lottoNumbers.shuffled().take(6).toSet()
    }
}