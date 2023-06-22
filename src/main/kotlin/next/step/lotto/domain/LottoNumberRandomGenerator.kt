package next.step.lotto.domain


object LottoNumberRandomGenerator : LottoNumberGenerator {

    private val lottoNumbers: List<LottoNumber> =
        (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER).map { LottoNumber.of(it) }

    override fun generate(): Set<LottoNumber> = lottoNumbers.shuffled().take(6).toSet()
}