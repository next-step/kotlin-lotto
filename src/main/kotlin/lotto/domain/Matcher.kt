package lotto.domain

class Matcher(private val winNumbers: WinNumbers, policies: List<WinPolicy>) {
    private val sortedPolicies = policies.sortedWith { a, b ->
        val difference = a.matchCount - b.matchCount

        if (difference == 0)
            a.useBonus.toInt() - b.useBonus.toInt()
        else
            difference
    }

    private fun Boolean.toInt() = if (this) 1 else 0

    fun makeResult(lottos: List<Lotto>): List<LottoMatchResult> =
        sortedPolicies.map {
            LottoMatchResult(
                matchCount = it.matchCount,
                price = it.priceAmount,
                winCount = lottos.count { lotto -> it.isMatch(winNumbers, lotto) }
            )
        }
}
