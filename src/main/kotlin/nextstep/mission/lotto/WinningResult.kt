package nextstep.mission.lotto

data class WinningResult(
    var threeMatch: Int = 0,
    var fourMatch: Int = 0,
    var fiveMatch: Int = 0,
    var sixMatch: Int = 0,
) {

    fun increase(winningCount: Int) {
        when (winningCount) {
            3 -> threeMatch++
            4 -> fourMatch++
            5 -> fiveMatch++
            6 -> sixMatch++
        }
    }

    fun rateOfReturn(totalPrice: Int): Double {
        val totalPrize: Int = WinningPrize.findPrize(3) * threeMatch +
            WinningPrize.findPrize(4) * fourMatch +
            WinningPrize.findPrize(5) * fiveMatch +
            WinningPrize.findPrize(6) * sixMatch
        return totalPrize.toDouble() / totalPrice.toDouble()
    }
}
