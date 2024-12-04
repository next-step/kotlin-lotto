package lotto.domain

class Match(private val matchCount: Int, private val isMatchedBonusBall: Boolean) {
    fun rank(): LottoRank {
        if (matchCount == 6) {
            return LottoRank.FIRST
        }
        if (matchCount == 5 && isMatchedBonusBall) {
            return LottoRank.SECOND
        }
        if (matchCount == 5) {
            return LottoRank.THIRD
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH
        }
        return LottoRank.NONE
    }
}
