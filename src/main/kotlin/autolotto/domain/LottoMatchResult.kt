package autolotto.domain

import autolotto.enums.prize.Prize

data class LottoMatchResult(val matchCount: Int, val hasBonus: Boolean) {
    fun toPrize(): Prize? {
        return Prize.fromMatchCount(matchCount, hasBonus)
    }
}
