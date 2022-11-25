package lotto.domain

class LottoMatchResult(
    private val lottoMatchMap: Map<Int, LottoMatch>
) {

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
