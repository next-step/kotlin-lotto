package lotto.domain

class Lotto(
    private val lottoNumberGenerator: LottoNumberGenerator
) {

    val lottoNumbers: LottoNumbers = lottoNumberGenerator.generate().let { LottoNumbers.of(it) }

    fun matchLottoNumber(matchingNumbers: LottoNumbers): LottoRank {
        val matchedCount = lottoNumbers.getMatchingCount(matchingNumbers)
        return LottoRank.getByMatchCount(matchedCount)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
