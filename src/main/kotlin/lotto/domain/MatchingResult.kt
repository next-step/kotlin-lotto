package lotto.domain

enum class MatchingResult(val prizeAmount: Int, val matchNumber: Int) {
    MATCHED_THREE(5_000, 3),
    MATCHED_FOUR(50_000, 4),
    MATCHED_FIVE(1_500_000, 5),
    MATCHED_SIX(2_000_000_000, 6), ;

    companion object {
        private const val MATCH_NUMBER_TRANSFER_ERROR_MESSAGE = "로또 결과 이넘값 변환 오류가 발생하였습니다."
        private val matchNumberToMatchResultMap = entries.associateBy { it.matchNumber }

        fun fromMatchNumber(matchNumber: Int): MatchingResult? = matchNumberToMatchResultMap[matchNumber]

        fun getMatchLottoResult(matchResults: List<MatchingResult>): Map<MatchingResult, Int> =
            entries.associateWith { matchResult ->
                matchResults.count { it == matchResult }
            }
    }
}
