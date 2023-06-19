package lotto.domain

class WinningLotto(private val winning: Lotto) {

    fun match(lotto: Lotto): LottoResult {
        val matchCount = winning.matchCount(lotto)
        return LottoResult.lottoResult(matchCount)
    }
}
