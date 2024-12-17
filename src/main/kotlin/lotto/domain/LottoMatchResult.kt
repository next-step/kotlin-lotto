package lotto.domain

import lotto.enums.prize.Prize

data class LottoMatchResult(val matchCount: Int, val hasBonus: Boolean) {
    fun toPrize(): Prize? {
        return Prize.fromMatchCount(matchCount, hasBonus)
    }
}
