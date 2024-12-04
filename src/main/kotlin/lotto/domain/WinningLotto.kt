package lotto.domain

data class WinningLotto(private val winningLotto: Lotto, private val bonusBall: LottoNumber) {
    fun getUserRank(userLotto: Lotto): LottoRank {
        val matchCount = userLotto.getIntersectSize(this.winningLotto)
        val isMatchedBonusBall = userLotto.isMatchedBonusBall(bonusBall)
        return Match(matchCount, isMatchedBonusBall).rank()
    }
}
