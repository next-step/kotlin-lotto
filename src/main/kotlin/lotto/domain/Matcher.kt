package lotto.domain

class Matcher(private val winNumbers: WinNumbers, policies: List<WinPolicy>) {
    private val sortedPolicies = policies.sortedWith(
        compareBy({ it.matchCount }, { it.useBonus })
    )

    fun makeResult(lottos: List<Lotto>): List<LottoMatchResult> =
        sortedPolicies.map {
            LottoMatchResult(
                matchCount = it.matchCount,
                price = it.priceAmount,
                winCount = lottos.count { lotto -> it.isMatch(winNumbers, lotto) },
                bonus = it.useBonus,
            )
        }
}
