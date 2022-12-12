package lotto.domain

class MatchResults private constructor(val elements: List<MatchResult>) {
    companion object {
        fun of(elements: List<MatchResult>) = MatchResults(elements)
    }
}
