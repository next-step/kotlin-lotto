package lotto.domain

class Result(private val ranks: Map<String, Int>) {

    fun getRateOfReturn(money: Int): Double {
        val threeMatch = ranks.getValue("5등")
        val fourMatch = ranks.getValue("4등")
        val fiveMatch = ranks.getValue("3등")
        val bonusFiveMatch = ranks.getValue("2등")
        val sixMatch = ranks.getValue("1등")
        return (PrizeMoney.THREE_MONEY.totalMoney(threeMatch)
                + PrizeMoney.FOUR_MONEY.totalMoney(fourMatch)
                + PrizeMoney.FIVE_MONEY.totalMoney(fiveMatch)
                + PrizeMoney.BONUS_FIVE_MONEY.totalMoney(bonusFiveMatch)
                + PrizeMoney.SIX_MONEY.totalMoney(sixMatch)) / money.toDouble()
    }
}
