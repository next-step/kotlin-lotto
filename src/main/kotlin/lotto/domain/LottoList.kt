package lotto.domain

data class LottoList(
    private val lottoList: List<Lotto>
) {
    fun compare(winningLotto: Lotto, bonusLottoNumber: LottoNumber): List<LottoRank> =
        lottoList.mapNotNull { lotto: Lotto ->
            val matchCount = winningLotto.getMatchCount(lotto)
            val isBonusMatch = lotto.containLottoNumber(bonusLottoNumber)
            LottoRank.valueOf(matchCount, isBonusMatch)
        }
}
