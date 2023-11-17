package lotto.domain.enums

import lotto.domain.Prize

enum class Rank(
    val matchNumber: Int,
    val prize: Prize
) {
    FIRST(6, Prize(2_000_000_000)),
    SECOND(5, Prize(1_500_000)),
    THIRD(4, Prize(50_000)),
    FOURTH(3, Prize(5_000)),
    FIFTH(2, Prize(0)),
    SIXTH(1, Prize(0)),
    MISS(0, Prize(0))
}
