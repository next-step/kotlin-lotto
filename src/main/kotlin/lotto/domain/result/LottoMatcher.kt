package lotto.domain.result

class LottoMatcher {
    private val _matcher: MutableMap<LottoRank, Int> = LottoRank.values().associateWith { 0 }.toMutableMap()

    fun rank(matchInfos: List<MatchInfo>): LottoResult {
        matchInfos.forEach { _matcher.computeIfPresent(LottoRank.of(it)) { _, matchCount -> matchCount + 1 } }
        return LottoResult(_matcher)
    }
}
