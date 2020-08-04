package lotto.domain

class Result(private val ranks: Map<Int, Int>) {

    fun getRateOfReturn(money: Int): Double {
        val threeMatch = ranks.getValue(3)
        val fourMatch = ranks.getValue(4)
        val fiveMatch = ranks.getValue(5)
        val sixMatch = ranks.getValue(6)
        return (PrizeMoney.THREE_MONEY.totalMoney(threeMatch) + PrizeMoney.FOUR_MONEY.totalMoney(fourMatch) + PrizeMoney.FIVE_MONEY.totalMoney(
            fiveMatch
        ) + PrizeMoney.SIX_MONEY.totalMoney(sixMatch)) / money.toDouble()
    }

    fun getRanks(): List<Int> = listOf(ranks.getValue(3), ranks.getValue(4), ranks.getValue(5), ranks.getValue(6))
}
