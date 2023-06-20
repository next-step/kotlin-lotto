package lotto.domain

data class Lotto(val pickedNumbers: List<Int>) {
    fun getCountOfMatch(otherLotto: Lotto): Int {
        return (pickedNumbers intersect otherLotto.pickedNumbers.toSet()).size
    }
}

data class LottoStatics(val ranks: Map<LottoRank, Int>, val totalBuyAmount: Int, val totalWinningPrice: Int, val rateOfReturn: Double)
