package lotto.domain

class LottoMatchResult(
    private val lottoMatchMap: Map<LottoRank, LottoMatch>
) {

    fun setMatchResult(matchNumber: Int) {
        LottoRank.valueOf(matchNumber)?.let { lottoRank ->
            lottoMatchMap[lottoRank]?.let {
                it.matchTotalCount++
                it
            }
        }
    }

    fun getMatchResult(): List<LottoMatch> =
        lottoMatchMap.values.toList()
}
