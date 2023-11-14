package lotto.domain.enums

import lotto.domain.Prize

enum class RANK(
    val sameNumber: Int,
    val prize: Prize
) {
    FIRST(6, Prize(2000000000)),
    SECOND(5, Prize(1500000)),
    THIRD(4, Prize(50000)),
    FOURTH(3, Prize(5000)),
}
