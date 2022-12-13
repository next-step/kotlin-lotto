package lotto.domain

class MatchResults private constructor(val elements: List<MatchResult>) {
    val totalReward: Int = elements.sumOf { it.reward }

    companion object {
        fun of(elements: List<MatchResult>) = MatchResults(elements)
    }
}
