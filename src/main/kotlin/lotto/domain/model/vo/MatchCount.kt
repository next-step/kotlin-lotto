package lotto.domain.model.vo

/**
 * 로또 번호 당첨 개수
 * */
@JvmInline
value class MatchCount(val matchCount: Int) {
    init {
        require(matchCount in MIN_MATCH_COUNT..MAX_MATCH_COUNT) {
            "당청 개수는 $MIN_MATCH_COUNT ~ ${MAX_MATCH_COUNT}개의 숫자만 들어와야 합니다."
        }
    }

    companion object {
        private const val MIN_MATCH_COUNT = 0
        private const val MAX_MATCH_COUNT = 10

        fun valueOf(matchCount: Int) = MatchCount(matchCount)
    }
}
