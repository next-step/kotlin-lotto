package lotto.domain

object LottoResultChecker {
    fun checkWinningLotto(winningLotto: Lotto, lotto: Lotto): LottoResult {
        val matchCount = winningLotto.numbers.intersect(lotto.numbers.toSet()).size
        return LottoResult(lotto, LottoPrize.of(matchCount))
    }
}
