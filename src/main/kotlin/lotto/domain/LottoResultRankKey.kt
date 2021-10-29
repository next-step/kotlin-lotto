package lotto.domain

data class LottoResultRankKey(val matchedCount: MatchedCount, val matchedBonusNumber: Boolean = false) {
    fun rank(): LottoResultRank {
        return LottoResultRank.getRank(this)
    }
}
