package lotto.domain

data class Lotto(val pickedNumbers: List<Int>) {
    fun getCountOfMatch(otherLotto: Lotto): Int {
        return otherLotto.pickedNumbers.count { number -> pickedNumbers.contains(number) }
    }
}

data class LottoResult(val pickedNumbers: List<Int>, val lottoRank: LottoRank)

data class LottoStatics(val ranks: Map<LottoRank, Int>, val totalBuyAmount: Int, val totalWinningPrice: Int, val rateOfReturn: Double)
