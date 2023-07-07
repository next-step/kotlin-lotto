package lotto.domain

class Lotto(
    val lottoNumbers: LottoNumbers,
    val type: LottoType
) {

    fun getLottoRank(lottoWinningNumbers: LottoWinningNumbers): LottoRank {
        val lottoMatchCount = lottoWinningNumbers.match(lottoNumbers)
        return LottoRank.getRank(lottoMatchCount)
    }

    companion object {
        const val LOTTO_PRICE = 1_000

        fun of(lottoNumberGenerator: LottoNumberGenerator): Lotto {
            return Lotto(lottoNumberGenerator.generate().let { LottoNumbers.of(it) }, LottoType.AUTO)
        }
    }
}
