package lotto

class Matcher(val winNumbers: WinNumbers, policies: List<WinPolicy>) {
    private val sortedPolicies = policies.sortedBy { it.matchCount }

    fun makeResult(lotto: List<Lotto>): List<MatchResult> {
        return sortedPolicies.map {
            MatchResult(
                matchCount = it.matchCount,
                price = it.priceAmount,
                winCount = 0
            )
        }
    }
}
