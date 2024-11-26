package lotto.step2.domain

enum class RewardType(val matchCount: Int, val winningAmount: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    NONE(0, 0),
    ;

    companion object {
        fun of(matchCount: Int): RewardType {
            return entries.find { it.matchCount == matchCount }
                ?: throw IllegalArgumentException("일치하는 RewardType이 없습니다. [matchCount=$matchCount]")
        }
    }
}
