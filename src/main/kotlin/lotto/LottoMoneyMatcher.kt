package lotto

import lotto.enums.LottoRank

class LottoMoneyMatcher {

    fun winningMoneyCheck(collectLottoRanks: List<LottoRank>, collectBonusCount: Int): Int {
        return LottoRank.getLottoPrizeMoneyByCount(collectLottoRanks, collectBonusCount)
    }
}
