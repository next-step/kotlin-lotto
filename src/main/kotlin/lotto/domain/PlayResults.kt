package lotto.domain

class PlayResults private constructor(matchResults: MatchResults, buyAmount: Int) {
    private var _aggregations: MutableMap<MatchResult, Int> = INITIAL_AGGREGATIONS

    val aggregations: Map<MatchResult, Int>
        get() = _aggregations.toMap()

    val totalReward: Int = matchResults.totalReward

    val profitRate: Double = totalReward / buyAmount.toDouble()

    init {
        matchResults.elements.map {
            aggregateCount(it)
        }
    }

    operator fun get(matchResult: MatchResult): Int = aggregations[matchResult]
        ?: throw IllegalArgumentException(MATCH_RESULT_NOT_FOUND_ERROR.format(matchResult.name))

    private fun aggregateCount(matchResult: MatchResult) {
        if (matchResult.isNotNoting()) {
            _aggregations.merge(matchResult, ADDITIONAL_VALUE, Int::plus)
        }
    }

    companion object {
        private const val MATCH_RESULT_NOT_FOUND_ERROR = "[%s]에 해당하는 당첨 결과를 찾을 수 없습니다."
        private const val INITIAL_COUNT: Int = 0
        private const val ADDITIONAL_VALUE: Int = 1

        private val INITIAL_AGGREGATIONS: MutableMap<MatchResult, Int> = MatchResult.values()
            .associateWith { INITIAL_COUNT }
            .run { this - MatchResult.NOT_WINNING }
            .toMutableMap()

        fun of(matchResults: MatchResults, buyAmount: Int): PlayResults =
            PlayResults(matchResults, buyAmount)
    }
}
