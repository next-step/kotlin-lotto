package lotto.domain.model

enum class Rank(val matchCount: Int, val reward: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(matchCount: Int, isMatchBonusNumber: Boolean = false): Rank = values().find { it.matchCount == matchCount }
            ?.let { if (it == THIRD && isMatchBonusNumber) SECOND else it }
            ?: takeIf { matchCount in MISS.matchCount until FIFTH.matchCount }?.let { MISS }
            ?: throw IllegalArgumentException("로또 숫자의 일치 수는 로또 숫자 수의 범위를 벗어날 수 없습니다. matchCount=$matchCount")
    }
}
