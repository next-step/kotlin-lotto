package nextstep.mission.lotto

data class WinningResult(
    var threeMatch: Int = 0,
    var fourMatch: Int = 0,
    var fiveMatch: Int = 0,
    var sixMatch: Int = 0
) {

    fun increase(winningCount: Int) {
        when (winningCount) {
            3 -> threeMatch++
            4 -> fourMatch++
            5 -> fiveMatch++
            6 -> sixMatch++
        }
    }
}
