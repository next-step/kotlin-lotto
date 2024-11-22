package lotto.domain

@JvmInline
value class MatchedCount(val value: Int) {
    init {
        require(value >= 0) { "MatchedCount는 음수일 수 없습니다." }
    }
}
