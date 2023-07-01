package lotto.domain

class Lotto(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {

    val lottoNumbers: LottoNumbers = lottoNumberGenerator.generate().let { LottoNumbers.of(it) }

    fun matchNumbers(lottoWinningNumbers: LottoWinningNumbers): LottoRank {
        val lottoMatchCount = lottoWinningNumbers.match(lottoNumbers)
        return LottoRank.getRank(lottoMatchCount)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
