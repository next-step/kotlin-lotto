package lotto.domain

class WinningLotto(
    private val winningNumbers: Set<LottoNumber>
) : Lotto(winningNumbers) {

    fun rankOfLotto(lotto: Lotto): LottoRank? {
        val numOfMatch = numOfMatch(lotto)
        val rank = LottoRank.rankOfMatchedNum(numOfMatch)
        return rank
    }

    private fun numOfMatch(lotto: Lotto): Int {
        return winningNumbers.intersect(lotto.lottoNumbers).count()
    }
}
