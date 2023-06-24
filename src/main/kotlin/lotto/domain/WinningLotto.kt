package lotto.domain

class WinningLotto(
    private val winningNumbers: Set<LottoNumber>,
    private val bonusNumber: LottoNumber
) : Lotto(winningNumbers) {

    //TODO : bonusNum 활용해야 함
    fun rankOfLotto(lotto: Lotto): LottoRank? {
        val numOfMatch = numOfMatch(lotto)
        val rank = LottoRank.of(numOfMatch, true)
        return rank
    }

    private fun numOfMatch(lotto: Lotto): Int {
        return winningNumbers.intersect(lotto.lottoNumbers).count()
    }
}
