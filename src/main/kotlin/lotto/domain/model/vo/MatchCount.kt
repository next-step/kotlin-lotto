package lotto.domain.model.vo

/**
 * 로또 번호 맞춘 횟수
 * */
@JvmInline
value class MatchCount(val matchCount: Int) {
    init {
        require(matchCount in MIN_MATCH_COUNT..MAX_MATCH_COUNT) {
            "로또 번호 맞춘 횟수는 $MIN_MATCH_COUNT ~ ${MAX_MATCH_COUNT}개의 숫자만 들어와야 합니다."
        }
    }

    companion object {
        private const val MIN_MATCH_COUNT = 0
        private const val MAX_MATCH_COUNT = 6

        fun valueOf(matchCount: Int) = MatchCount(matchCount)
    }
}
