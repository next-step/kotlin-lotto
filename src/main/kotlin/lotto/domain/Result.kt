package lotto.domain

class Result(private val money: Int, private val ranks: Map<PrizeMoney, Int>) {

    fun getRateOfReturn(): Double = (
            PrizeMoney.FIRST.totalMoney(ranks.getValue(PrizeMoney.FIRST))
                    + PrizeMoney.SECOND.totalMoney(ranks.getValue(PrizeMoney.SECOND))
                    + PrizeMoney.THIRD.totalMoney(ranks.getValue(PrizeMoney.THIRD))
                    + PrizeMoney.FOURTH.totalMoney(ranks.getValue(PrizeMoney.FOURTH))
                    + PrizeMoney.FIFTH.totalMoney(ranks.getValue(PrizeMoney.FIFTH))
            ) / money.toDouble()
}
