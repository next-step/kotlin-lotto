package lotto.domain

class LottoMatchResult {
    private val lottoMatchMap: Map<Int, LottoMatch>

    constructor() {
        lottoMatchMap = mutableMapOf()
        for (matchNumber in MATCH_THREE..MATCH_SIX) {
            lottoMatchMap[matchNumber] = LottoMatch(matchNumber, getReward(matchNumber), DEFAULT_MATCH_COUNT)
        }
    }

    constructor(matchMap: Map<Int, LottoMatch>) {
        lottoMatchMap = matchMap
    }

    fun getReward(matchNumber: Int): Long =
        when (matchNumber) {
            MATCH_THREE -> FOURTH_PLACE_REWARD
            MATCH_FOUR -> THIRD_PLACE_REWARD
            MATCH_FIVE -> SECOND_PLACE_REWARD
            MATCH_SIX -> FIRST_PLACE_REWARD
            else -> DEFAULT_REWARD
        }

    fun setMatchResult(matchNumber: Int) {
        val lottoMatch = lottoMatchMap[matchNumber]
        lottoMatch?.let {
            it.matchCount++
            it
        }
    }

    fun getMatchResult(): List<LottoMatch> =
        lottoMatchMap.values.toList()

    companion object {
        private const val DEFAULT_MATCH_COUNT: Long = 0
        private const val DEFAULT_REWARD: Long = 0
        private const val MATCH_THREE = 3
        private const val MATCH_FOUR = 4
        private const val MATCH_FIVE = 5
        private const val MATCH_SIX = 6
        private const val FOURTH_PLACE_REWARD: Long = 5000
        private const val THIRD_PLACE_REWARD: Long = 50000
        private const val SECOND_PLACE_REWARD: Long = 1500000
        private const val FIRST_PLACE_REWARD: Long = 2000000000
    }
}
