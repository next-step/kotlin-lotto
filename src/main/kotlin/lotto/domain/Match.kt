package lotto.domain

class Match(private val matchCount: Int, private val isMatchedBonusBall: Boolean) {
    fun rank(): LottoRank =
        when {
            matchCount == 6 -> LottoRank.FIRST
            matchCount == 5 && isMatchedBonusBall -> LottoRank.SECOND
            matchCount == 5 -> LottoRank.THIRD
            matchCount == 4 -> LottoRank.FOURTH
            matchCount == 3 -> LottoRank.FIFTH
            else -> LottoRank.NONE
        }
}
