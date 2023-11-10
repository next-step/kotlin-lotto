package lotto.enums

import lotto.domain.Record

enum class Rank(
    val matchCount: IntRange,
    val reward: Int,
) {
    FOURTH_RANK(3..3, 5000),
    THIRD_RANK(4..4, 50000),
    SECOND_RANK(5..5, 1500000),
    FIRST_RANK(6..6, 2000000000),
    NONE_RANK(0..2, 0),
    ;

    companion object {
        fun records(): List<Record> {
            return values().filter {
                it != NONE_RANK
            }.map {
                Record.of(it.matchCount.min(), it.reward)
            }
        }
    }
}
