package step2.lotto.domain

class MatchResults private constructor(private val elements: List<MatchResult>) {
    fun contains(matchResult: MatchResult): Boolean = elements.contains(matchResult)

    fun containsAll(vararg matchResult: MatchResult): Boolean =
        elements.containsAll(matchResult.toList())

    companion object {
        fun of(matchResults: List<MatchResult>): MatchResults = MatchResults(matchResults)
    }
}
