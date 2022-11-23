package lotto.domain

class LottoMatchResult {
    private val lottoMatchMap: Map<Int, LottoMatch>

    constructor() {
        lottoMatchMap = mutableMapOf()
        LottoRank.getMatchCountList().forEach { matchCount ->
            lottoMatchMap[matchCount] =
                LottoMatch(
                    matchCount,
                    LottoRank.getReward(matchCount)
                )
        }
    }

    constructor(matchMap: Map<Int, LottoMatch>) {
        lottoMatchMap = matchMap
    }

    fun setMatchResult(matchNumber: Int) {
        val lottoMatch = lottoMatchMap[matchNumber]
        lottoMatch?.let {
            it.matchCount++
            it
        }
    }

    fun getMatchResult(): List<LottoMatch> =
        lottoMatchMap.values.toList()
}
