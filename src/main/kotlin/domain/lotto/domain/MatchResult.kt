package domain.lotto.domain

import domain.lotto.error.EmptyMatchResultMapException

@JvmInline
value class MatchResult private constructor(val matchResult: Map<MatchBoard, Int>) {
    fun winnings(): Int = matchResult.asSequence()
        .sumOf { Math.multiplyExact(it.value, it.key.matchPrize) }

    companion object {
        fun of(matchResult: Map<MatchBoard, Int>): MatchResult {
            validateNullOrEmpty(matchResult)
            return MatchResult(matchResult.toMap())
        }

        private fun validateNullOrEmpty(matchResult: Map<MatchBoard, Int>) {
            if (matchResult.isNullOrEmpty()) {
                throw EmptyMatchResultMapException
            }
        }
    }
}
