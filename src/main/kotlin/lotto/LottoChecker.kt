package lotto

import lotto.domain.Lotto
import lotto.enums.LottoRank

class LottoChecker {

    fun lottoCheck(winningNumber: String, lottoBundle: List<Lotto>): List<LottoRank> {

        val numbers = winningNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }

        val result = mutableListOf<LottoRank>()
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.numbers.forEach { number ->
                if (numbers.contains(number)) {
                    count++
                }
            }
            if(count != 0) {
                result.add(LottoRank.getLottoRankByCount(count))
            }
        }
        return result.toList()
    }

    fun winningMoneyCheck(collectLottoRanks: List<LottoRank>): Int {
        var winningMoney = 0
        collectLottoRanks.forEach { rank ->
            winningMoney += rank.prizeMoney
        }
        return winningMoney
    }

    fun lottoResultGroup(collectLottoRanks: List<LottoRank>): Map<Int, Int> {
        return collectLottoRanks.sorted().groupingBy { it.count }.eachCount()
    }
}
