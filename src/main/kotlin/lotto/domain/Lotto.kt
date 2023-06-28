package lotto.domain

class Lotto(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {

    val lottoNumbers: LottoNumbers = lottoNumberGenerator.generate().let { LottoNumbers.of(it) }

    fun matchLottoNumber(lottoMatchNumbers: LottoMatchNumbers): LottoRank {
        val lottoMatchCount = lottoNumbers.matchNumbers(lottoMatchNumbers)
        return LottoRank.getRank(lottoMatchCount)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
