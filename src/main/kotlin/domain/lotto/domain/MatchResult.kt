package domain.lotto.domain

import domain.lotto.error.EmptyMatchResultMapException

@JvmInline
value class MatchResult private constructor(private val _matchResult: Map<MatchBoard, Int>) {

    val matchResult: Map<MatchBoard, Int>
        get() = _matchResult.toMap()

    companion object {
        fun of(matchResult: Map<MatchBoard, Int>): MatchResult =
            if (matchResult.isNotEmpty()) MatchResult(matchResult.toMap())
            else throw EmptyMatchResultMapException
    }
}
