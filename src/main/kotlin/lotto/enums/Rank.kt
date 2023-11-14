package lotto.enums

import lotto.domain.Record

enum class Rank(
    val matchCount: Int,
    val reward: Int,
) {
    FOURTH_RANK(3, 5_000),
    THIRD_RANK(4, 50_000),
    SECOND_RANK(5, 1_500_000),
    FIRST_RANK(6, 2_000_000_000),
    NONE_RANK(0, 0),
    ;

    companion object {
        fun excludeNoneRankOfRecord(): Set<Record> {
            return values().filter {
                it != NONE_RANK
            }.map {
                Record.of(it.matchCount, it.reward)
            }.toSet()
        }
    }
}
