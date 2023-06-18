package lotto

import lotto.enums.LottoRank

class LottoMoneyMatcher {

    fun winningMoneyCheck(collectLottoRanks: List<LottoRank>, collectBonusCount: Int): Int {
        var winningMoney = 0
        collectLottoRanks.forEach { rank ->
            winningMoney += rank.prizeMoney
        }
        if (collectBonusCount != 0) winningMoney += LottoRank.BONUS_COLLECT.prizeMoney * collectBonusCount
        return winningMoney
    }
}
