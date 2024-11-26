package lotto.response

import lotto.domain.LottoRank

class LottoRankResponse(private val rank: LottoRank, private val count: Int) {
    fun toFormattedString(): String {
        return "${rankDescription()} (${rank.prize} 원) - $count 개"
    }

    private fun rankDescription(): String {
        val matchDescription = "${rank.matchCount}개 일치"
        val bonusDescription = if (rank.isBonusRequired) ", 보너스 볼 일치" else ""
        return matchDescription + bonusDescription
    }
}
