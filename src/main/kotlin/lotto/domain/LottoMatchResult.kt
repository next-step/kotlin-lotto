package lotto.domain

class LottoMatchResult(
    private val lottoMatchMap: Map<LottoRank, LottoMatch>
) {

    fun setMatchResult(matchNumber: Int, isBonus: Boolean) {
        LottoRank.valueOf(matchNumber, isBonus)?.let { lottoRank ->
            lottoMatchMap[lottoRank]?.let {
                it.matchTotalCount++
                it.isBonusNumber = isBonus
                it
            }
        }
    }

    fun getMatchResult(): List<LottoMatch> =
        lottoMatchMap.values.toList()
}
