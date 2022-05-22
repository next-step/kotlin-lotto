package lotto.domain

class Matcher(private val winNumbers: WinNumbers, policies: List<WinPolicy>) {
    private val sortedPolicies = policies.sortedBy { it.matchCount }

    fun makeResult(lottos: List<Lotto>): List<MatchResult> =
        sortedPolicies.map {
            MatchResult(
                matchCount = it.matchCount,
                price = it.priceAmount,
                winCount = lottos.count { lotto -> it.isMatch(winNumbers, lotto) }
            )
        }
}
