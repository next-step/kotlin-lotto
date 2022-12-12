package lotto.domain

class PlayResult private constructor(val lotto: Lotto, matchResult: MatchResult) {
    companion object {
        fun of(lotto: Lotto, matchResult: MatchResult): PlayResult = PlayResult(lotto, matchResult)
    }
}
