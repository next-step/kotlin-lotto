package lotto.response

import lotto.domain.LottoRank

class LottoRankResponse(private val rank: LottoRank, private val count: Int) {
    fun toFormattedString(): String {
        return "${rank.description} (${rank.prize} 원) - $count 개"
    }
}
