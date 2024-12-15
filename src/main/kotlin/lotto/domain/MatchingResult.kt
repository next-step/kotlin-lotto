package lotto.domain

typealias MatchValues = Pair<Int, BonusMatchResult>

enum class MatchingResult(val prizeAmount: Int, val matchNumber: Int, val bonusMatchResult: BonusMatchResult) {
    MATCHED_THREE(5_000, 3, BonusMatchResult.NO_EFFECT),
    MATCHED_FOUR(50_000, 4, BonusMatchResult.NO_EFFECT),
    MATCHED_FIVE(1_500_000, 5, BonusMatchResult.NOT_MATCH),
    MATCHED_FIVE_WITH_BONUS(30_000_000, 5, BonusMatchResult.MATCH),
    MATCHED_SIX(2_000_000_000, 6, BonusMatchResult.NO_EFFECT), ;

    companion object {
        private const val RELATED_BONUS_MATCH_NUMBER = 5
        private val matchValuesToMatchResultMap =
            entries.associateBy { result ->
                MatchValues(result.matchNumber, result.bonusMatchResult)
            }

        fun getResult(
            matchNumber: Int,
            isBonusMatched: Boolean,
        ): MatchingResult? {
            val bonusMatchResult = getBonusMatchResult(matchNumber, isBonusMatched)
            return matchValuesToMatchResultMap[MatchValues(matchNumber, bonusMatchResult)]
        }

        private fun getBonusMatchResult(
            matchNumber: Int,
            isBonusMatched: Boolean,
        ): BonusMatchResult {
            if (matchNumber != RELATED_BONUS_MATCH_NUMBER) return BonusMatchResult.NO_EFFECT
            return if (isBonusMatched) BonusMatchResult.MATCH else BonusMatchResult.NOT_MATCH
        }

        fun getMatchLottoResult(matchResults: List<MatchingResult>): Map<MatchingResult, Int> =
            entries.associateWith { matchResult ->
                matchResults.count { it == matchResult }
            }
    }
}
