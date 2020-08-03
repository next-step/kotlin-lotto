package lotto.domain

class Result(val lottos: List<Lotto>) {

    fun getRateOfReturn(money: Int): Double {
        val threeMatch = getThreeMatch()
        val fourMatch = getFourMatch()
        val fiveMatch = getFiveMatch()
        val sixMatch = getSixMatch()
        return (PrizeMoney.THREE_MONEY.totalMoney(threeMatch) + PrizeMoney.FOUR_MONEY.totalMoney(fourMatch) + PrizeMoney.FIVE_MONEY.totalMoney(
            fiveMatch
        ) + PrizeMoney.SIX_MONEY.totalMoney(sixMatch)) / money.toDouble()
    }

    fun getAllMatchResult(): List<Int> = listOf(getThreeMatch(), getFourMatch(), getFiveMatch(), getSixMatch())

    private fun getThreeMatch(): Int = lottos.filter { it.correctNumber == 3 }.size

    private fun getFourMatch(): Int = lottos.filter { it.correctNumber == 4 }.size

    private fun getFiveMatch(): Int = lottos.filter { it.correctNumber == 5 }.size

    private fun getSixMatch(): Int = lottos.filter { it.correctNumber == 6 }.size
}
