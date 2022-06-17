package lotto.view

import lotto.domain.Rank

data class RankView(val rank: Rank, val profit: Int) {

    fun print() {
        getRankMessage(rank)
    }

    private fun getRankMessage(rank: Rank): String {
        var matchMessage = "${rank.countOfMatch}개 일치"
        if (rank.matchedBonus) matchMessage += BONUS_MESSAGE
        return matchMessage + " (${rank.prize.toInt()}원)"
    }

    companion object {
        private const val BONUS_MESSAGE = ", 보너스 볼 일치"
    }
}