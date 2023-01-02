package service

import domain.PurchasedLotto
import domain.Rank
import domain.WinningLotto

class CalculateWinningStatistic {
    fun calculateRank(candidate: List<PurchasedLotto>, winningLotto: WinningLotto): List<Rank> =
        candidate.map { Rank.find(it.calculateWinningCount(winningLotto)) }

    fun calculatePrize(ranks: List<Rank>): Int =
        Rank.values().fold(0) { totalPrize, nowRank -> totalPrize + nowRank.prize }

    fun calculateRate(prize: Int, purchase: Int): Double =
        prize.toDouble() / prize
}