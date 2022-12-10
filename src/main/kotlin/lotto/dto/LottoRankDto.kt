package lotto.dto

import lotto.domain.LottoRank

data class LottoRankDto(val countOfMatch: Int, val winningMoney: Int) {
    fun isSecondPlace(): Boolean {
        return LottoRank.valueOf(countOfMatch, winningMoney) == LottoRank.SECOND
    }
}
