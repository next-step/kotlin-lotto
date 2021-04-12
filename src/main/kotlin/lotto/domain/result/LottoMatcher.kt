package lotto.domain.result

class LottoMatcher {
    private val matcher: MutableMap<LottoRank, Int> = LottoRank.values().associateWith { 0 }.toMutableMap()

    fun rank(matchInfos: List<MatchInfo>): LottoResult {
        matchInfos.forEach { matcher.computeIfPresent(LottoRank.from(it)) { _, matchCount -> matchCount + 1 } }
        return LottoResult(matcher)
    }
}
