package lotto.domain

class LottoWinningNumbers(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.toSet().size == NUMBERS_SIZE) { "로또 당첨 번호는 중복없이 $NUMBERS_SIZE 개 입니다." }
    }

    fun getLottoResult(lottos: List<Lotto>): LottoResult {
        val result = lottos.map { getRank(it) }
        return LottoResult(result)
    }

    private fun getRank(lotto: Lotto): LottoRank {
        val matchingCount = lotto.getMatchingCount(lottoNumbers)
        return LottoRank.of(matchingCount)
    }

    companion object {
        const val NUMBERS_SIZE = 6
    }
}
