package domain.lotto.domain

import domain.lotto.error.EmptyMatchResultMapException

@JvmInline
value class MatchResult private constructor(private val matchResult: Map<MatchBoard, Int>) {

    companion object {
        fun of(matchResult: Map<MatchBoard, Int>): MatchResult =
            if (matchResult.isNotEmpty()) MatchResult(matchResult)
            else throw EmptyMatchResultMapException
    }
}
