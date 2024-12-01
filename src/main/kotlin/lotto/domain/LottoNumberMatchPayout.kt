package lotto.domain

object LottoNumberMatchPayout {
    fun matchCountToPayout(matchCount: Int): Int {
        return when (matchCount) {
            THREE_NUMBER_MATCH -> THREE_NUMBER_MATCH_LOTTO_PAYOUT
            FOUR_NUMBER_MATCH -> FOUR_NUMBER_MATCH_LOTTO_PAYOUT
            FIVE_NUMBER_MATCH -> FIVE_NUMBER_MATCH_LOTTO_PAYOUT
            SIX_NUMBER_MATCH -> SIX_NUMBER_MATCH_LOTTO_PAYOUT
            else -> NO_MATCH_PAYOUT
        }
    }

    const val THREE_NUMBER_MATCH: Int = 3
    private const val THREE_NUMBER_MATCH_LOTTO_PAYOUT: Int = 5000
    const val FOUR_NUMBER_MATCH: Int = 4
    private const val FOUR_NUMBER_MATCH_LOTTO_PAYOUT: Int = 50000
    const val FIVE_NUMBER_MATCH: Int = 5
    private const val FIVE_NUMBER_MATCH_LOTTO_PAYOUT: Int = 1500000
    const val SIX_NUMBER_MATCH: Int = 6
    private const val SIX_NUMBER_MATCH_LOTTO_PAYOUT: Int = 2000000000
    private const val NO_MATCH_PAYOUT: Int = 0
}
