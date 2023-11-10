package lotto.dto

import lotto.enum.Rank

class LottoRankDeterminer {

    fun determineRank(matchCount: Int, matchBonus: Boolean): Rank {
        return Rank.valueOf(matchCount, matchBonus)
    }
}
